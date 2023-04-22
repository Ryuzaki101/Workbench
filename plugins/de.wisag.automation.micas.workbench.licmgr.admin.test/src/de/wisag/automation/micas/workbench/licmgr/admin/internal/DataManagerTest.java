package de.wisag.automation.micas.workbench.licmgr.admin.internal;

import java.util.Date;

import org.eclipse.core.runtime.Path;
import org.junit.Test;

import de.wisag.automation.micas.workbench.licmgr.admin.LicenseData;
import de.wisag.automation.micas.workbench.licmgr.admin.LicenseHistoryItem;

public class DataManagerTest {
	@Test
	public void testSerializer() throws Exception {
	
	}
	
	@Test
	public void testLoad() throws Exception {
	
	}
	
	@Test
	public void testSave() throws Exception {
		LicenseData data = new LicenseData();
		data.setAbandoned(false);
		data.setProductId("46521080-dd8f-11e0-9572-0800200c9a66");
		data.setProductName("MicasOS");
		
		data.setCompanyName("Itemis");
		data.setEmail("sag@ich.net");
		data.setLicenseId("CX-43552222");
		data.setName("LicenseName");
		LicenseHistoryItem item;
		
		item = new LicenseHistoryItem();
		item.setCreated(new Date(0));
		item.setRequestData("REQ-DATA1");
		item.setResponseData("RESP-DATA1");
		data.addHistoryItem(item);

		item = new LicenseHistoryItem();
		item.setCreated(new Date(System.currentTimeMillis()));
		item.setRequestData("REQ-DATA2");
		item.setResponseData("RESP-DATA3");
		data.addHistoryItem(item);

		DataManager dataManager = new DataManager();
		dataManager.save(data,new Path("data.xml"));
		
	}
}
