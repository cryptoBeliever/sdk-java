package io.nem.sdk.api;

import io.nem.core.crypto.PublicKey;
import io.nem.sdk.model.account.PublicAccount;
import io.nem.sdk.model.blockchain.NetworkType;
import io.nem.sdk.model.mosaic.MosaicId;
import io.nem.sdk.model.namespace.NamespaceId;
import io.nem.sdk.model.transaction.AccountMetadataTransactionFactory;
import io.nem.sdk.model.transaction.MosaicMetadataTransactionFactory;
import io.nem.sdk.model.transaction.NamespaceMetadataTransactionFactory;
import io.reactivex.Observable;
import java.math.BigInteger;

/**
 * Metadata transaction service.
 *
 * @author Ravi Shanker
 */
public interface MetadataTransactionService {

    /**
     * Create an Account Metadata Transaction that knows how to set or update a value.
     *
     * @param networkType the network type
     * @param targetPublicAccount the target public account
     * @param key the key of the metadata
     * @param value the value of the metadata.
     * @param senderPublicKey the sender (signer) public account.
     * @return an observable of AccountMetadataTransactionFactory of a transaction that can be
     * announced.
     */
    Observable<AccountMetadataTransactionFactory> createAccountMetadataTransactionFactory(
        NetworkType networkType,
        PublicAccount targetPublicAccount,
        BigInteger key,
        String value,
        PublicKey senderPublicKey);

    /**
     * Create an Mosaic Metadata Transaction that knows how to set or update a value.
     *
     * @param networkType the network type
     * @param targetPublicAccount the target public account
     * @param key the key of the metadata
     * @param value the value of the metadata.
     * @param senderPublicKey the sender (signer) public account.
     * @param targetId the mosaic id of the attached metadata.
     * @return an observable of AccountMetadataTransactionFactory of a transaction that can be
     * announced.
     */
    Observable<MosaicMetadataTransactionFactory> createMosaicMetadataTransactionFactory(
        NetworkType networkType,
        PublicAccount targetPublicAccount,
        BigInteger key,
        String value,
        PublicKey senderPublicKey,
        MosaicId targetId);

    /**
     * Create an Namespace Metadata Transaction that knows how to set or update a value.
     *
     * @param networkType the network type
     * @param targetPublicAccount the target public account
     * @param key the key of the metadata
     * @param value the value of the metadata.
     * @param senderPublicKey the sender (signer) public account.
     * @param targetId the namespace id of the attached metadata.
     * @return an observable of AccountMetadataTransactionFactory of a transaction that can be
     * announced.
     */
    Observable<NamespaceMetadataTransactionFactory> createNamespaceMetadataTransactionFactory(
        NetworkType networkType,
        PublicAccount targetPublicAccount,
        BigInteger key,
        String value,
        PublicKey senderPublicKey,
        NamespaceId targetId);
}
