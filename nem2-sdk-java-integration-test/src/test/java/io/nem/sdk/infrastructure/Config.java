package io.nem.sdk.infrastructure;

import io.vertx.core.json.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Config {

    private static final String CONFIG_JSON = "config.json";
    private static Config ourInstance = new Config();
    private JsonObject config;

    private Config() {
        try (InputStream inputStream =
            BaseIntegrationTest.class.getClassLoader().getResourceAsStream(CONFIG_JSON)) {
            if (inputStream == null) {
                throw new IOException(CONFIG_JSON + " not found");
            }
            String result =
                new BufferedReader(new InputStreamReader(inputStream))
                    .lines()
                    .collect(Collectors.joining("\n"));
            this.config = new JsonObject(result);

        } catch (IOException ignored) {
        }
    }

    public static Config getInstance() {
        return ourInstance;
    }

    public JsonObject getConfig() {
        return this.config;
    }

    public String getApiUrl() {
        return this.config.getString("apiUrl");
    }

    public String getNetworkType() {
        return this.config.getString("networkType");
    }

    public String getGenerationHash() {
        return this.config.getString("generationHash");
    }

    public Long getTimeoutSeconds() {
        return this.config.getLong("timeoutSeconds");
    }

    public String getTestAccountPrivateKey() {
        return this.config.getJsonObject("testAccount").getString("privateKey");
    }

    public String getTestAccountPublicKey() {
        return this.config.getJsonObject("testAccount").getString("publicKey");
    }

    public String getTestAccountAddress() {
        return this.config.getJsonObject("testAccount").getString("address");
    }

    public String getMultisigAccountPrivateKey() {
        return this.config.getJsonObject("multisigAccount").getString("privateKey");
    }

    public String getMultisigAccountPublicKey() {
        return this.config.getJsonObject("multisigAccount").getString("publicKey");
    }

    public String getMultisigAccountAddress() {
        return this.config.getJsonObject("multisigAccount").getString("address");
    }

    public String getCosignatoryAccountPrivateKey() {
        return this.config.getJsonObject("cosignatoryAccount").getString("privateKey");
    }

    public String getCosignatoryAccountPublicKey() {
        return this.config.getJsonObject("cosignatoryAccount").getString("publicKey");
    }

    public String getCosignatoryAccountAddress() {
        return this.config.getJsonObject("cosignatoryAccount").getString("address");
    }

    public String getCosignatory2AccountPrivateKey() {
        return this.config.getJsonObject("cosignatory2Account").getString("privateKey");
    }

    public String getCosignatory2AccountPublicKey() {
        return this.config.getJsonObject("cosignatory2Account").getString("publicKey");
    }

    public String getCosignatory2AccountAddress() {
        return this.config.getJsonObject("cosignatory2Account").getString("address");
    }

    public String getCosignatory3AccountPrivateKey() {
        return this.config.getJsonObject("cosignatory3Account").getString("privateKey");
    }

    public String getCosignatory3AccountPublicKey() {
        return this.config.getJsonObject("cosignatory3Account").getString("publicKey");
    }

    public String getCosignatory3AccountAddress() {
        return this.config.getJsonObject("cosignatory3Account").getString("address");
    }

    public String getCosignatory4AccountPrivateKey() {
        return this.config.getJsonObject("cosignatory4Account").getString("privateKey");
    }

    public String getCosignatory4AccountPublicKey() {
        return this.config.getJsonObject("cosignatory4Account").getString("publicKey");
    }

    public String getCosignatory4AccountAddress() {
        return this.config.getJsonObject("cosignatory4Account").getString("address");
    }

    public String getTestAccount2PrivateKey() {
        return this.config.getJsonObject("testAccount2").getString("privateKey");
    }

    public String getTestAccount2PublicKey() {
        return this.config.getJsonObject("testAccount2").getString("publicKey");
    }

    public String getTestAccount2Address() {
        return this.config.getJsonObject("testAccount2").getString("address");
    }

    public String getTestAccount3PrivateKey() {
        return this.config.getJsonObject("testAccount3").getString("privateKey");
    }

    public String getTestAccount3PublicKey() {
        return this.config.getJsonObject("testAccount3").getString("publicKey");
    }

    public String getTestAccount3Address() {
        return this.config.getJsonObject("testAccount3").getString("address");
    }

    public String getTestAccountNoBalancePrivateKey() {
        return this.config.getJsonObject("testAccountNoBalance").getString("privateKey");
    }

    public String getTestAccountNoBalancePublicKey() {
        return this.config.getJsonObject("testAccountNoBalance").getString("publicKey");
    }

    public String getTestAccountNoBalanceAddress() {
        return this.config.getJsonObject("testAccountNoBalance").getString("address");
    }

    public String getHarvestingAccountPrivateKey() {
        return this.config.getJsonObject("harvestingAccount").getString("privateKey");
    }

    public String getHarvestingAccountPublicKey() {
        return this.config.getJsonObject("harvestingAccount").getString("publicKey");
    }

    public String getHarvestingAccountAddress() {
        return this.config.getJsonObject("harvestingAccount").getString("address");
    }
}
