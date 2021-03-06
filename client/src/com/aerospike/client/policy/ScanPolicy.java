/*
 * Copyright 2012-2017 Aerospike, Inc.
 *
 * Portions may be licensed to Aerospike, Inc. under one or more contributor
 * license agreements WHICH ARE COMPATIBLE WITH THE APACHE LICENSE, VERSION 2.0.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.aerospike.client.policy;

/**
 * Container object for optional parameters used in scan operations.
 */
public final class ScanPolicy extends Policy {
	/**
	 * Percent of data to scan.  Valid integer range is 1 to 100.
	 * Default is 100.
	 */
	public int scanPercent = 100;
	
	/**
	 * Maximum number of concurrent requests to server nodes at any point in time.
	 * If there are 16 nodes in the cluster and maxConcurrentNodes is 8, then scan requests
	 * will be made to 8 nodes in parallel.  When a scan completes, a new scan request will 
	 * be issued until all 16 nodes have been scanned.
	 * <p>
	 * This field is only relevant when concurrentNodes is true.
	 * Default (0) is to issue requests to all server nodes in parallel.
	 */
	public int maxConcurrentNodes;

	/**
	 * Maximum time in milliseconds to wait when polling socket for availability prior to
	 * performing an operation on the socket on the server side.  Zero means there is no
	 * socket timeout. 
	 * <p>
	 * Default: 10000 ms
	 */
	public int socketTimeout = 10000;

	/**
	 * Issue scan requests in parallel or serially. 
	 */
	public boolean concurrentNodes = true;
	
	/**
	 * Indicates if bin data is retrieved. If false, only record digests are retrieved.
	 */
	public boolean includeBinData = true;
	
	/**
	 * Include large data type bin values in addition to large data type bin names.
	 * If false, LDT bin names will be returned, but LDT bin values will be empty.
	 * If true,  LDT bin names and the entire LDT bin values will be returned.
	 * Warning: LDT values may consume huge of amounts of memory depending on LDT size.
	 * Default: false
	 */
	public boolean includeLDT = false;

	/**
	 * Terminate scan if cluster in fluctuating state.
	 */
	public boolean failOnClusterChange;

	/**
	 * Default constructor.
	 */
	public ScanPolicy() {
		// Scans should not retry.
		super.maxRetries = 0;
	}
}
