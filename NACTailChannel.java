package com.ivansoft.iso;

import java.io.IOException;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOPackager;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.channel.NACChannel;
import org.jpos.util.LogEvent;
import org.jpos.util.Logger;

public class NACTailChannel extends NACChannel{
	 public NACTailChannel(String hostname, int portNumber,
		      ISOPackager packager, byte[] bytes) {
		    super(hostname, portNumber, packager,bytes);
		  }
		  protected void getMessageTrailler() throws IOException {
		   
		    byte[] b = new byte[1];
		    serverIn.readFully(b, 0, 1);
		  
		  }
		  protected void sendMessageTrailler(ISOMsg m, int len) throws IOException {
			  byte[] tEtx = new byte[] { (byte)0x03};
		    serverOut.write(tEtx);
		  }
		  protected void sendMessageLength(int len) throws IOException {
		    len++; // one byte trailler
		    serverOut.write(len >> 8);
		    serverOut.write(len);
		  }
		  protected int getMessageLength() throws IOException, ISOException {
		    int l = 0;
		    byte[] b = new byte[2];
		    Logger.log(new LogEvent(this, "get-message-length"));
		    while (l == 0) {
		      serverIn.readFully(b, 0, 2);
		      l = ((((int) b[0]) & 0xFF) << 8) | (((int) b[1]) & 0xFF);
		      if (l == 0) {
		        serverOut.write(b);
		        serverOut.flush();
		      }
		    }
		    Logger.log(new LogEvent(this, "got-message-length", Integer.toString(l)));
		    return l - 1; // trailler length
		  }

}
