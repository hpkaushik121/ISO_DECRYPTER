package com.iso.decypter.ISOUtils;



import com.iso.decypter.Icons;
import com.solab.iso8583.IsoMessage;
import com.solab.iso8583.IsoValue;
import com.solab.iso8583.MessageFactory;
import com.solab.iso8583.parse.ConfigParser;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;

import java.net.URL;


public class UnPackISOMessage {

//   public static void main(String[] args) throws ISOException {
//
//GenericPackager packager = new GenericPackager(UnPackISOMessage.class.getClassLoader().getResourceAsStream("iso87ascii.xml"));
//
//      String rs = "0110F23E4695AFE0860000000000000000211652491010095360263120000000000000000511225808523062225808051125020511541105100000C00000000C000000000620000106627480335249101009536026D2502221001944557306288502341548622002212101KI582033LAGPOOO6548306288502341@2101KI58GRAVITY          NG5660402002566C0000000440102001566C0000000440100349F36020092910a17996AF06516F9B60012015510101711344101f7dc82439a09bd9b3e59d8ab5ab76f46c7e68afe537f6380f3d954ad9e95db11";
////byte[] rs= {48, 50, 49, 48, 70, 50, 51, 69, 52, 52, 68, 53, 65, 66, 69, 48, 57, 50, 50, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 51, 49, 49, 54, 53, 50, 52, 57, 49, 48, 49, 48, 48, 57, 53, 51, 54, 48, 50, 54, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 49, 48, 48, 48, 48, 48, 53, 49, 49, 49, 54, 50, 56, 53, 49, 73, 83, 79, 86, 97, 108, 117, 101, 60, 110, 117, 108, 108, 62, 49, 54, 50, 56, 53, 49, 48, 53, 49, 49, 50, 53, 48, 50, 48, 53, 49, 49, 53, 52, 49, 49, 48, 53, 49, 48, 48, 49, 50, 68, 48, 48, 48, 48, 48, 48, 48, 48, 67, 48, 48, 48, 48, 48, 48, 48, 48, 48, 54, 53, 50, 52, 57, 49, 48, 48, 54, 48, 48, 48, 48, 48, 48, 51, 51, 53, 50, 52, 57, 49, 48, 49, 48, 48, 57, 53, 51, 54, 48, 50, 54, 68, 50, 53, 48, 50, 50, 50, 49, 48, 48, 49, 57, 52, 52, 53, 53, 55, 54, 55, 51, 55, 52, 57, 56, 50, 56, 48, 49, 57, 57, 52, 50, 50, 49, 50, 49, 48, 49, 75, 73, 53, 56, 50, 51, 48, 50, 83, 79, 48, 48, 48, 48, 53, 54, 52, 53, 52, 77, 101, 100, 117, 115, 97, 32, 84, 101, 115, 116, 98, 101, 100, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 76, 65, 78, 71, 53, 54, 54, 48, 70, 53, 51, 51, 48, 52, 50, 66, 50, 54, 48, 53, 48, 66, 49, 48, 50, 52, 57, 49, 48, 97, 51, 69, 49, 52, 51, 56, 56, 57, 49, 49, 67, 53, 70, 65, 68, 69, 51, 48, 51, 53, 48, 48, 54, 48, 49, 48, 49, 48, 49, 48, 49, 53, 53, 49, 48, 49, 48, 49, 55, 49, 49, 51, 52, 52, 49, 48, 49, 48, 48, 48, 57, 48, 53, 48, 48, 52, 94, 78, 83, 84, 52, 52, 98, 54, 48, 51, 101, 101, 101, 101, 50, 50, 50, 100, 100, 102, 56, 48, 51, 99, 53, 56, 54, 100, 101, 100, 48, 49, 50, 51, 97, 57, 49, 50, 50, 56, 49, 100, 100, 50, 52, 99, 51, 54, 56, 102, 53, 53, 50, 97, 51, 98, 55, 101, 56, 48, 51, 101, 49, 54, 54, 52, 54, 52};
//      // System.out.println("DATA : " + data + UnPackISOMessage.class.getClassLoader().getResourceAsStream("resources/iso87ascii.xml"));
////
//      try {
//    	  IsoMessage isoMsg =new UnPackISOMessage().unPackResponse(rs);
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//
//      //  isoMsg.setPackager(packager);
////      unPackResponseTest(data);
////        unPackResponse(data);
////        //new com.estel.adapter.cardpe.handler.UnPackISOMessage().unPackResponse("2210F23C05C18FE2601E06000000007E000019281232000000002538600001035620000000000100312121637201403110011201403121216372014031410100010001000100020000006012069889980623455469c88995ba58739c5b0000101OwegsTermID0000412reliance12340019owegstech solutions003124003050020000000000100000000020025800306100306200306300312300031230003100030710003106000310700031080031090031100003111");
////     // new com.estel.adapter.cardpe.handler.UnPackISOMessage().unPackResponse("2210F23C05C18FE2601E06000000007E000019281232000000002538600001035620000000000100312121637201403110011201403121216372014031410100010001000100020000006012069889980623455469c88995ba58739c5b0000101OwegsTermID0000412reliance12340019owegstech solutions003124003050020000000000100000000020025800306100306200306300312300031230003100030710003106000310700031080031090031100003111");
////       //new com.estel.adapter.cardpe.handler.UnPackISOMessage().unPackResponse("0430723820010E800000166073845000005014001000000000000010081911394671963211394608193560612345600000043491927129000AGS00001");
////       new UnPackISOMessage().unPackResponse("080022380000008000059C0000071317012617012617012607132070HE8801901014912006090001712B0F4F01FD3031819F8FEA8247E52FC4BEAFF011E957A771A1AB2BF9940312AF");
////
//  }

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