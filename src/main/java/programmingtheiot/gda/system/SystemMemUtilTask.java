/**
 * This class is part of the Programming the Internet of Things
 * project, and is available via the MIT License, which can be
 * found in the LICENSE file at the top level of this repository.
 * 
 * You may find it more helpful to your design to adjust the
 * functionality, constants and interfaces (if there are any)
 * provided within in order to meet the needs of your specific
 * Programming the Internet of Things project.
 */
package programmingtheiot.gda.system;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;
import java.util.logging.Logger;

import programmingtheiot.common.ConfigConst;

/**
 * System memory utilization task implementation.
 * 
 */
public class SystemMemUtilTask extends BaseSystemUtilTask
{
	// static
	
	private static final Logger _Logger =
		Logger.getLogger(SystemMemUtilTask.class.getName());
	
	// constructors
	
	/**
	 * Default constructor.
	 * 
	 */
	public SystemMemUtilTask()
	{
		super(ConfigConst.NOT_SET, ConfigConst.DEFAULT_TYPE_ID);
	}
	
	
	// public methods
	
	/**
	 * Returns the current JVM memory utilization as a percentage.
	 * 
	 * @return float The memory utilization percentage
	 */
	@Override
	public float getTelemetryValue()
	{
		MemoryUsage memUsage = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
		double memUsed = (double) memUsage.getUsed();
		double memMax  = (double) memUsage.getMax();
		
		_Logger.fine("Mem used: " + memUsed + "; Mem Max: " + memMax);
		
		double memUtil = (memUsed / memMax) * 100.0d;
		
		return (float) memUtil;
	}
	
}