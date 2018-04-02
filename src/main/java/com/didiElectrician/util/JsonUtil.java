package com.didiElectrician.util;

import net.sf.json.JSONArray;

import java.util.List;

public class JsonUtil {

	public static String toJsonString(@SuppressWarnings("rawtypes") List list) {
		JSONArray jsonObject = JSONArray.fromObject(list);
		return jsonObject.toString();
	}
}
