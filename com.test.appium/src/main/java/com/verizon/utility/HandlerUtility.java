package com.verizon.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.thoughtworks.xstream.XStream;

public class HandlerUtility {

	static UtilityParser handler = new UtilityParser();

	public static ConfiguredCapabilities getCapabilities() {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(APIConstants.PATH_XML);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XStream xstream = new XStream();
		xstream.alias("capabilities", ConfiguredCapabilities.class);
		ConfiguredCapabilities loadedConfig = (ConfiguredCapabilities) xstream.fromXML(fileReader);
		return loadedConfig;

	}

}