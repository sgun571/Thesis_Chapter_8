package com.couchbase.client.core.message.dcp;

import com.couchbase.client.core.annotations.InterfaceAudience;
import com.couchbase.client.core.annotations.InterfaceStability;
import com.couchbase.client.core.message.CouchbaseRequest;

/**
 * Common interface for all DCP requests.
 *
 * Note that they can flow in both directions. For example, {@link ConnectionType#PRODUCER}
 * connection, will means that requests will flow from server to client.
 *
 * @author Sergey Avseyev
 * @since 1.1.0
 */
@InterfaceStability.Experimental
@InterfaceAudience.Private
public interface DCPRequest extends CouchbaseRequest {

    short partition();
    DCPRequest partition(short id);
}
