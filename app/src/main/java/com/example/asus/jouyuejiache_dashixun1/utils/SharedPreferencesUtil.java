package com.example.asus.jouyuejiache_dashixun1.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.example.asus.jouyuejiache_dashixun1.activity.log.App;

import java.util.Map;

public class SharedPreferencesUtil {
	
	private SharedPreferences sp;
	
	private SharedPreferencesUtil(String sharedName) {
		sp = App.content.getSharedPreferences(sharedName, Context.MODE_PRIVATE);
	}
	
	public static SharedPreferencesUtil getInstance(String sharedName) {
		return new SharedPreferencesUtil(sharedName);
	}
	
	/**
	 * 
	 * @param key
	 * @param value String、Boolean、Integer、Long、Float
	 */
	public void saveInfo(String key, Object value) {
		SharedPreferences.Editor editor = sp.edit();
		if (value instanceof String) {
			editor.putString(key, (String) value);
		} else if (value instanceof Boolean) {
			editor.putBoolean(key, (Boolean) value);
		} else if (value instanceof Integer) {
			editor.putInt(key, (Integer) value);
		} else if (value instanceof Long) {
			editor.putLong(key, (Long) value);
		} else if (value instanceof Float) {
			editor.putFloat(key, (Float) value);
		}
		editor.apply();
	}
	
	/**
	 * 
	 * @param key
	 * @param defValue String、Boolean、Integer、Long、Float
	 * @return
	 */
	public Object getValueByKey(String key, Object defValue) {
		Object object = null;
		if (defValue instanceof String) {
			object = sp.getString(key, (String) defValue);
		} else if (defValue instanceof Boolean) {
			object = sp.getBoolean(key, (Boolean) defValue);
		} else if (defValue instanceof Integer) {
			object = sp.getInt(key, (Integer) defValue);
		} else if (defValue instanceof Long) {
			object = sp.getLong(key, (Long) defValue);
		} else if (defValue instanceof Float) {
			object = sp.getFloat(key, (Float) defValue);
		}
		return object;
	}
	
	public Map<String, ?> getAll() {
		return sp.getAll();
	}
	
	/**
	 * 清除Share文件
	 */
	public void clearShareFile() {
		SharedPreferences.Editor editor = sp.edit();
		editor.clear();
		editor.apply();
	}
	
	public void registerChangeListener(OnSharedPreferenceChangeListener listener) {
		sp.registerOnSharedPreferenceChangeListener(listener);
	}
	
}
