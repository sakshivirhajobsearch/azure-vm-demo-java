package com.azure.vm;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AzureVMManagerTest {

	@Test
	public void testListVirtualMachines() {
		
		// Replace with your Azure Service Principal details
		String clientId = "YOUR_CLIENT_ID";
		String clientSecret = "YOUR_CLIENT_SECRET";
		String tenantId = "YOUR_TENANT_ID";
		String subscriptionId = "YOUR_SUBSCRIPTION_ID";

		AzureVMManager vmManager = new AzureVMManager(clientId, clientSecret, tenantId, subscriptionId);
		List<String> vmNames = vmManager.listVirtualMachines();

		assertNotNull(vmNames);
		System.out.println("Virtual Machines: " + vmNames);
	}
}