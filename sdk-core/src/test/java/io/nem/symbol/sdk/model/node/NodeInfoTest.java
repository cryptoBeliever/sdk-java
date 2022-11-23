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
package io.nem.symbol.sdk.model.node;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.nem.symbol.sdk.model.account.Account;
import io.nem.symbol.sdk.model.network.NetworkType;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class NodeInfoTest {

  static Account account;

  @BeforeAll
  public static void setup() {
    account =
        new Account(
            "787225aaff3d2c71f4ffa32d4f19ec4922f3cd869747f267378f81f8e3fcb12d",
            NetworkType.TEST_NET);
  }

  @Test
  void shouldCreateNodeInfo() {
    List<RoleType> roles = Arrays.asList(RoleType.API_NODE, RoleType.VOTING_NODE);
    NodeInfo nodeInfo =
        new NodeInfo(
            account.getPublicKey(),
            3000,
            NetworkType.TEST_NET,
            0,
            roles,
            "localhost",
            "test",
            "abc");
    assertEquals("localhost", nodeInfo.getHost());
    assertEquals(0, nodeInfo.getVersion());
    assertEquals(3000, nodeInfo.getPort());
    assertEquals("test", nodeInfo.getFriendlyName());
    assertEquals(NetworkType.TEST_NET, nodeInfo.getNetworkIdentifier());
    assertEquals(roles, nodeInfo.getRoles());
    assertEquals(nodeInfo.getPublicKey(), account.getPublicKey());
    assertEquals("abc", nodeInfo.getNetworkGenerationHashSeed());
  }
}
