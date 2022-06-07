package com.iso.decypter.ISOUtils;

import java.util.List;

public class TLV {

	public String tag;
	public String length;
	public String value;
	
	public boolean isNested;
	public List<TLV> tlvList;

	@Override
	public String toString() {
		return "TLV{" +
				"tag='" + tag + '\'' +
				", length='" + length + '\'' +
				", value='" + value + '\'' +
				", isNested=" + isNested +
				'}';
	}



	public static String toString(List< TLV> tlvList) {
		StringBuilder buffer=new StringBuilder();
		for (TLV item:tlvList) {
			item.tag= item.tag.toUpperCase();
			buffer.append(item.tag).append(" ").append(EMVTags.getInstance().getTitle(item.tag)).append(" \n \t ").append(item.value).append("\n");
		}
		return buffer.toString();
	}


}
