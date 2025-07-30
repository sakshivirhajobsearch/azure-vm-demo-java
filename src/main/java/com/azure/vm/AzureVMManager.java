package com.azure.vm;

import java.util.ArrayList;
import java.util.List;

import com.azure.core.credential.TokenCredential;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.azure.resourcemanager.AzureResourceManager;
import com.azure.resourcemanager.compute.models.VirtualMachine;

public class AzureVMManager {
	
	private final AzureResourceManager azure;

	public AzureVMManager(String clientId, String clientSecret, String tenantId, String subscriptionId) {
		
		TokenCredential credential = new ClientSecretCredentialBuilder().clientId(clientId).clientSecret(clientSecret)
				.tenantId(tenantId).build();

		AzureProfile profile = new AzureProfile(tenantId, subscriptionId, AzureEnvironment.AZURE);
		this.azure = AzureResourceManager.authenticate(credential, profile).withSubscription(subscriptionId);
	}

	public List<String> listVirtualMachines() {
		
		List<String> vmNames = new ArrayList<>();
		for (VirtualMachine vm : azure.virtualMachines().list()) {
			vmNames.add(vm.name());
		}
		return vmNames;
	}
}