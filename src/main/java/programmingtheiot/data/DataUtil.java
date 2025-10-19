/**
 * This class is part of the Programming the Internet of Things
 * project, and is available via the MIT License, which can be
 * found in the LICENSE file at the top level of this repository.
 */

package programmingtheiot.data;

import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DataUtil
{
	// static
	
	private static final Logger _Logger =
		Logger.getLogger(DataUtil.class.getName());
	
	private static final DataUtil _Instance = new DataUtil();

	public static final DataUtil getInstance()
	{
		return _Instance;
	}
	
	// private var's
	
	private Gson gson = null;
	
	// constructors
	
	private DataUtil()
	{
		super();
		
		this.gson = new GsonBuilder().setPrettyPrinting().create();
		
		_Logger.info("Created DataUtil instance.");
	}
	
	// public methods
	
	public String actuatorDataToJson(ActuatorData actuatorData)
	{
		if (actuatorData != null) {
			String jsonData = this.gson.toJson(actuatorData);
			return jsonData;
		}
		return null;
	}
	
	public String sensorDataToJson(SensorData sensorData)
	{
		if (sensorData != null) {
			String jsonData = this.gson.toJson(sensorData);
			return jsonData;
		}
		return null;
	}
	
	public String systemPerformanceDataToJson(SystemPerformanceData sysPerfData)
	{
		if (sysPerfData != null) {
			String jsonData = this.gson.toJson(sysPerfData);
			return jsonData;
		}
		return null;
	}
	
	public ActuatorData jsonToActuatorData(String jsonData)
	{
		if (jsonData != null && jsonData.trim().length() > 0) {
			ActuatorData data = this.gson.fromJson(jsonData, ActuatorData.class);
			return data;
		}
		return null;
	}
	
	public SensorData jsonToSensorData(String jsonData)
	{
		if (jsonData != null && jsonData.trim().length() > 0) {
			SensorData data = this.gson.fromJson(jsonData, SensorData.class);
			return data;
		}
		return null;
	}
	
	public SystemPerformanceData jsonToSystemPerformanceData(String jsonData)
	{
		if (jsonData != null && jsonData.trim().length() > 0) {
			SystemPerformanceData data = this.gson.fromJson(jsonData, SystemPerformanceData.class);
			return data;
		}
		return null;
	}
}
