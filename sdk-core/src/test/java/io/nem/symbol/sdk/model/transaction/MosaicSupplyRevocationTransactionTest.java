/*
 * Copyright 2020 NEM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.nem.symbol.sdk.model.transaction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.nem.symbol.core.utils.ConvertUtils;
import io.nem.symbol.sdk.model.account.Account;
import io.nem.symbol.sdk.model.account.Address;
import io.nem.symbol.sdk.model.mosaic.Currency;
import io.nem.symbol.sdk.model.network.NetworkType;
import java.math.BigInteger;
import java.time.Duration;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MosaicSupplyRevocationTransactionTest extends AbstractTransactionTester {

  Account account = new Account(
      "041e2ce90c31cd65620ed16ab7a5a485e5b335d7e61c75cd9b3a2fed3e091728", NetworkType.MIJIN_TEST);

  @Test
  void createAMosaicSupplyRevocationTransactionViaConstructor() {

    Duration epochAdjustment = Duration.ofSeconds(100);
    MosaicSupplyRevocationTransaction mosaicSupplyRevocationTx =
        MosaicSupplyRevocationTransactionFactory.create(
                NetworkType.MIJIN_TEST,
                Deadline.create(epochAdjustment),
                Address.createFromRawAddress("SDZWZJUAYNOWGBTCUDBY3SE5JF4NCC2RDM6SIGQ"),
                Currency.CAT_CURRENCY.createRelative(BigInteger.valueOf(10)))
            .build();

    assertEquals(NetworkType.MIJIN_TEST, mosaicSupplyRevocationTx.getNetworkType());
    assertEquals(1, mosaicSupplyRevocationTx.getVersion());
    assertTrue(
        LocalDateTime.now()
            .isBefore(mosaicSupplyRevocationTx.getDeadline().getLocalDateTime(epochAdjustment)));
    assertEquals(BigInteger.valueOf(0), mosaicSupplyRevocationTx.getMaxFee());
    assertEquals(
        new BigInteger("9636553580561478212"),
        mosaicSupplyRevocationTx.getMosaic().getId().getId());
    assertEquals(BigInteger.valueOf(10000000), mosaicSupplyRevocationTx.getMosaic().getAmount());
    assertEquals(
        "90F36CA680C35D630662A0C38DC89D4978D10B511B3D241A",
        mosaicSupplyRevocationTx.getSourceAddress().encoded(NetworkType.MIJIN_TEST));
  }

  @Test
  @DisplayName("Serialization")
  void serialization() {

    MosaicSupplyRevocationTransaction transaction =
        MosaicSupplyRevocationTransactionFactory.create(
                NetworkType.MIJIN_TEST,
                new Deadline(BigInteger.ONE),
                Address.createFromRawAddress("SDZWZJUAYNOWGBTCUDBY3SE5JF4NCC2RDM6SIGQ"),
                Currency.CAT_CURRENCY.createRelative(BigInteger.valueOf(10)))
                .signer(account.getPublicAccount())
                .build();

    String expected =
         "A80000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000F6503F78FBF99544B906872DDB392F4BE707180D285E7919DBACEF2E9573B1E60000000001904D430000000000000000010000000000000090F36CA680C35D630662A0C38DC89D4978D10B511B3D241A44B262C46CEABB858096980000000000";

    assertSerialization(expected, transaction);

    String expectedEmbedded =
         "5800000000000000F6503F78FBF99544B906872DDB392F4BE707180D285E7919DBACEF2E9573B1E60000000001904D4390F36CA680C35D630662A0C38DC89D4978D10B511B3D241A44B262C46CEABB858096980000000000";

    assertEmbeddedSerialization(expectedEmbedded, transaction);
  }
}
