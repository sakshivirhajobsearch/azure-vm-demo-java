package com.azure.vm;

import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.resourcemanager.AzureResourceManager;


public class AzureManagerExample {
	
	public static void main(String[] args) {
		
		AzureProfile profile = new AzureProfile(AzureEnvironment.AZURE);
		AzureResourceManager azure = AzureResourceManager
				.authenticate(new DefaultAzureCredentialBuilder().build(), profile).withDefaultSubscription();

		// Example usage
		azure.resourceGroups().list().forEach(rg -> System.out.println(rg.name()));
	}
}