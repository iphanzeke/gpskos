package com.ivansoft.iso;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMUX;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOPackager;
import org.jpos.iso.ISORequest;
import org.jpos.iso.channel.ASCIIChannel;
import org.jpos.iso.channel.NACChannel;
import org.jpos.iso.packager.GenericPackager;

import com.ivansoft.model.RespService;

public class ServiceISO {
	
	private String hostname;
	private int portNumber;
	private String requestISO;
	private String responseISO; 
	
	

	public String getRequestISO() {
		return requestISO;
	}

	public void setRequestISO(String requestISO) {
		this.requestISO = requestISO;
	}

	public String getResponseISO() {
		return responseISO;
	}

	public void setResponseISO(String responseISO) {
		this.responseISO = responseISO;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public int getPortNumber() {
		return portNumber;
	}

	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}


	public static ISOMUX isoMux = null;
	
	
	public  String networkTransport(ISOMsg reqMsg) throws UnknownHostException, IOException {
        Socket connection = new Socket(getHostname(), getPortNumber());
        String clientRequest = "";
        try {
        	BufferedOutputStream bos = new BufferedOutputStream(connection.getOutputStream());

            OutputStreamWriter osw = new
     OutputStreamWriter(bos);
            int len = new String(reqMsg.pack()).length(); // get the length of the data
            // SInce your packager name says Postilion, I think this will work.
            osw.write(len >> 8); // send the length bytes in 2 bytes. this is the byte 1
            osw.write(len);// send the length bytes in 2 bytes. this is the byte 2
            System.out.println(new String(reqMsg.pack()));
            osw.write(new String(reqMsg.pack()));
            osw.flush();

          
            byte[] arrOutut = new byte[4096];
            int count = connection.getInputStream().read(arrOutut, 0, 4096);

           
            for (int outputCount = 0
    ; outputCount < count; outputCount++) {
                char response = (char) arrOutut[outputCount];
                clientRequest = clientRequest + response;
            }

        }catch(Exception e) {
        	e.printStackTrace();
        }finally {
        	 connection.close();
        }
        
       

        return clientRequest;
    }

	public static void createSocket(NACChannel channel) {
		if (isoMux == null) {
			isoMux = new ISOMUX(channel) {
				@Override
				protected String getKey(ISOMsg m) throws ISOException {
					return super.getKey(m);
				}
			};
			new Thread(isoMux).start();
		}
	}

	public String sendToHost(ISOMsg isoMSg) {
		
		ISOPackager packager;
		String resp = "";
		NACChannel channel = null; 	 	
		ISOMsg receivedRequest = null;
		try {
			System.out.println(getHostname()+":"+getPortNumber());
			packager = new GenericPackager("basic.xml");
			channel = new NACTailChannel(getHostname(), getPortNumber(), packager,null);
			channel.setTimeout(300000);
			channel.connect();
			channel.send(isoMSg);
			receivedRequest = channel.receive();
			System.out.println("Req [" + new String(receivedRequest.pack()) + "]");
			resp = new String(receivedRequest.pack());

//			 createSocket(channel);
//			 ISORequest req = new ISORequest(isoMSg);
//			 isoMux.queue(req);
//
//			 ISOMsg reply = req.getResponse(50*1000);
//			 if (reply != null) {
//			 System.out.println("Req ["+new String(isoMSg.pack()) + "]");
//			 resp = new String(reply.pack());
//			 System.out.println("Res ["+resp+ "]");
			
			// }

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// isoMux.terminate();

				channel.disconnect();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return resp;
	}

	public String prepareMsg(String jsonInput) throws ISOException {
		RespService rs = new RespService();
		ObjectMapper mapper = new ObjectMapper();
		ISOMsg resp = null;
		String logRes = "";
		ISOMsg reqMsg = new ISOMsg();
		// reqMsg.setHeader("ISO011000017".getBytes());
		try {
			ISOPackager packager = new GenericPackager("basic.xml");

			reqMsg.setPackager(packager);
		
			Map<String, Object> isoMap = mapper.readValue(jsonInput, new TypeReference<Map<String, Object>>() {
			});
			for (Map.Entry<String, Object> entry : isoMap.entrySet()) {
				
				 
				
				if (entry.getKey() == "mti") {
					reqMsg.setMTI(entry.getValue().toString());
				}else if(entry.getKey() == "ipaddress") {
					setHostname(entry.getValue().toString());
				}else if(entry.getKey() == "port") {
					setPortNumber(Integer.parseInt(entry.getValue().toString()));
				}else {
					reqMsg.set(entry.getKey(), entry.getValue().toString());
				}

			}
	
			System.out.println("Log request == "+new String(reqMsg.pack()));
			rs.setIsoRequest(new String(reqMsg.pack()));
			setRequestISO(new String(reqMsg.pack()));
			//logRes = networkTransport(reqMsg);
		
			logRes = sendToHost(reqMsg);
			System.out.println("Log response == "+logRes);
			setResponseISO(logRes);
			rs.setIsoResponse(logRes);
			rs.setJsonResponse(printISOMessage(logRes));

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			logRes = "{\"error\":\"timeout\"}";
		}

		return printISOMessage(logRes);
	}
	
	
	private String printISOMessage(String iso) {
		StringBuffer buffer = new StringBuffer();
        try {
        	ISOPackager  packager = new GenericPackager("basic.xml");
	            ISOMsg isoMsg = new ISOMsg();
	            isoMsg.setPackager(packager);
	            isoMsg.unpack(iso.getBytes());
        	buffer.append("{");
        	buffer.append("\n");
        	buffer.append("\"MTI\":\""+isoMsg.getMTI()+"\",");
        	buffer.append("\n");
        	
            for (int i = 1; i <= isoMsg.getMaxField(); i++) {
                if (isoMsg.hasField(i)) {
                	buffer.append("\""+i+"\":\""+isoMsg.getString(i).replace("\"", "###")+"\"");
                //	if(i != isoMsg.getMaxField()) {
                		buffer.append(",");
                	//}
                	
                	buffer.append("\n");
                  //  System.out.printf("Field  (%s) = %s%n", i, isoMsg.getString(i));
                }
            }
           // buffer.append(",");
            buffer.append("\"requestISO\":\""+getRequestISO().replace("\"", "###")+"\",");
            buffer.append("\n");
            buffer.append("\"responseISO\":\""+getResponseISO().replace("\"", "###")+"\"");
            buffer.append("\n");
            buffer.append("}");
           

            System.out.println("log response == "+buffer.toString());
        } catch (ISOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

}
