package net.scharitzer.cloud.provider.azure;

import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import net.scharitzer.cloud.provider.Provider;
import net.scharitzer.cloud.provider.ProviderException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Azure implements Provider {

	@Value("${azure.clientId}")
	private String clientId; // FIXME configuration class

	@Override
	public void responds() throws ProviderException {
		AzureProfile profile = new AzureProfile(AzureEnvironment.AZURE);
		System.out.println(clientId); // TODO remove
	}

}
