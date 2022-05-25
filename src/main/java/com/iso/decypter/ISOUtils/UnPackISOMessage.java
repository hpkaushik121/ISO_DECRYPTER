package com.iso.decypter.ISOUtils;



import com.google.gson.Gson;
import com.iso.decypter.Const;
import com.iso.decypter.Icons;
import com.solab.iso8583.IsoMessage;
import com.solab.iso8583.IsoValue;
import com.solab.iso8583.MessageFactory;
import com.solab.iso8583.parse.ConfigParser;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.packager.GenericPackager;

import java.net.URL;


public class UnPackISOMessage {

   public static void main(String[] args) throws ISOException {
//
//GenericPackager packager = new GenericPackager(UnPackISOMessage.class.getClassLoader().getResourceAsStream("iso87ascii.xml"));
//
//      String rs = "0810023800000280000005230714137159590714130523922101KI58";
byte[] rs= {48,50,48,48,70,50,51,67,52,54,68,49,50,57,69,48,56,50,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,50,49,49,56,53,48,54,49,48,57,48,51,50,57,52,48,48,50,52,55,50,49,48,48,49,48,48,48,48,48,48,48,48,48,48,49,48,48,48,48,48,53,50,53,49,48,53,48,51,54,48,48,48,48,48,54,49,48,53,48,51,54,48,53,50,53,50,53,48,52,53,52,49,49,48,53,49,48,48,49,48,48,48,52,68,48,48,48,48,48,48,48,48,48,54,53,48,54,49,48,57,51,52,53,48,54,49,48,57,48,51,50,57,52,48,48,50,52,55,50,49,68,50,53,48,52,54,50,49,49,48,49,49,50,56,56,49,52,49,51,49,55,51,54,50,57,55,55,54,54,50,49,50,49,48,49,75,73,53,56,50,51,48,50,83,79,48,48,48,48,53,54,52,53,52,78,79,87,78,79,87,32,68,73,71,73,84,65,76,32,83,89,83,84,69,77,83,32,86,73,32,32,76,65,78,71,32,32,32,32,32,32,32,32,32,53,54,54,50,53,56,57,70,50,54,48,56,68,57,53,65,53,49,67,48,49,52,53,55,57,67,50,53,57,70,50,55,48,49,52,48,57,70,49,48,50,48,48,70,65,53,48,49,54,50,51,56,51,50,50,52,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,70,48,49,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,57,70,51,55,48,52,53,50,54,65,53,51,54,57,57,70,51,54,48,50,48,48,49,70,57,53,48,53,52,50,56,48,48,48,56,48,48,48,57,65,48,51,50,50,48,53,50,53,57,67,48,49,48,48,57,70,48,50,48,54,48,48,48,48,48,48,48,49,48,48,48,48,53,70,50,65,48,50,48,53,54,54,53,70,51,52,48,49,48,49,56,50,48,50,53,56,48,48,57,70,49,65,48,50,48,53,54,54,57,70,48,51,48,54,48,48,48,48,48,48,48,48,48,48,48,48,57,70,51,51,48,51,69,48,70,56,67,56,57,70,51,52,48,51,52,49,48,51,48,50,57,70,51,53,48,49,50,50,48,49,53,53,49,48,49,48,49,53,49,49,51,52,52,49,48,49,50,54,70,48,49,53,69,49,57,50,51,48,69,48,70,69,51,50,66,70,49,69,56,51,67,52,70,53,67,70,51,55,54,57,70,54,66,51,65,68,54,50,66,66,55,65,49,55,65,51,70,53,55,54,50,56,49,68,56,70,51,53,49,54};
//      // System.out.println("DATA : " + data + UnPackISOMessage.class.getClassLoader().getResourceAsStream("resources/iso87ascii.xml"));
////
      try {
    	  System.out.println(new UnPackISOMessage().unPackResponseISO8583(rs));
	} catch (Exception e) {
//		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println();
//
//      //  isoMsg.setPackager(packager);
////      unPackResponseTest(data);
////        unPackResponse(data);
////        //new com.estel.adapter.cardpe.handler.UnPackISOMessage().unPackResponse("2210F23C05C18FE2601E06000000007E000019281232000000002538600001035620000000000100312121637201403110011201403121216372014031410100010001000100020000006012069889980623455469c88995ba58739c5b0000101OwegsTermID0000412reliance12340019owegstech solutions003124003050020000000000100000000020025800306100306200306300312300031230003100030710003106000310700031080031090031100003111");
////     // new com.estel.adapter.cardpe.handler.UnPackISOMessage().unPackResponse("2210F23C05C18FE2601E06000000007E000019281232000000002538600001035620000000000100312121637201403110011201403121216372014031410100010001000100020000006012069889980623455469c88995ba58739c5b0000101OwegsTermID0000412reliance12340019owegstech solutions003124003050020000000000100000000020025800306100306200306300312300031230003100030710003106000310700031080031090031100003111");
////       //new com.estel.adapter.cardpe.handler.UnPackISOMessage().unPackResponse("0430723820010E800000166073845000005014001000000000000010081911394671963211394608193560612345600000043491927129000AGS00001");
////       new UnPackISOMessage().unPackResponse("080022380000008000059C0000071317012617012617012607132070HE8801901014912006090001712B0F4F01FD3031819F8FEA8247E52FC4BEAFF011E957A771A1AB2BF9940312AF");
////
  }

    private static String logISOMsg(ISOMsg msg) throws ISOException {
        StringBuffer buffer=new StringBuffer();
        buffer.append("    ----ISO MESSAGE-----"+"\n");

        buffer.append("    MTI : " + msg.getMTI()+"\n");
        buffer.append(    "    msg.getMaxField()" + msg.getMaxField()+"\n");
            for (int i = 1; i <= msg.getMaxField(); i++) {
                if (msg.hasField(i)) {
                    if(i==2 || i==35 || i==52){
                        buffer.append("    Field-" + i + " : " +maskPan(msg.getString(i)+"")+"\n");
                    }else{
                        buffer.append("    Field-" + i + " : " + msg.getString(i)+"\n");
                    }

                }
            }
       return buffer.toString();
    }
    
    public static String logISOMsg(IsoMessage m) {
        StringBuffer buffer=new StringBuffer();
        buffer.append("    ----ISO MESSAGE-----"+"\n");

        	if (m != null) {
                buffer.append(String.format("    Message type: %04x%n"+"\n", m.getType()));
                buffer.append("    FIELD TYPE    VALUE"+"\n");
                for (int i = 2; i <= 128; i++) {
                    IsoValue<?> f = m.getField(i);
                    if (f != null) {
                        if(i==2 || i==35 || i==52){
                            buffer.append("    Field-" + i + " : " +maskPan( f.getValue()+"")+"\n");
                        }else{
                            buffer.append("    Field-" + i + " : " + f.getValue()+"\n");
                        }

                    }
                }
            }
            return buffer.toString();
    }

    public static String maskPan(String PAN) {
       if(Const.isAdmin){
           return PAN;
       }
//       return  PAN;
        String panStart6digit = PAN.substring(0, 6);
        String panlast4digit = PAN.substring(PAN.length() - 5, PAN.length() - 1);
        return panStart6digit + "XXXXXXXX" + panlast4digit;
    }
    public static String getUnpaddedValue(String originalString) {
        String unpadedString = "";

        if (originalString != null && !originalString.isEmpty()) {
            if (originalString.length() % 2 == 0) {
                for (int i = 1; i <= originalString.length(); i += 2) {
                    unpadedString += originalString.charAt(i);


                }
            }
        }

        return unpadedString;


    }

    public   String unPackResponseJ8583(String responsePacket) throws Exception {
    	IsoMessage m;

        	URL url= Icons.getResourceURL("/ico/j8583Config.xml");
        	MessageFactory mf = new MessageFactory();
        	 ConfigParser.configureFromUrl(mf,url);
            String data = responsePacket.trim();
            System.out.println("data = " + data);
//           data = data.substring(1, data.length());
            System.out.println("data = " + data);
             m = mf.parseMessage(data.getBytes(),0);


        return logISOMsg(m);

    }
    
    public String unPackResponseISO8583(byte[] responsePacket) throws ISOException {
        ISOMsg isoMsg = null;
            GenericPackager packager = new GenericPackager(Icons.getResourceStream("/ico/iso87ascii.xml"));

            //String data = responsePacket.trim();
            //System.out.println("data = " + data);
           //data = data.substring(1, data.length());
            System.out.println("data = " + new String(responsePacket));
            isoMsg = new ISOMsg();
            isoMsg.setPackager(packager);
            isoMsg.unpack(responsePacket);


        	


        return logISOMsg(isoMsg);

    }
    
    

    

}