/**
 * Copyright (c) 2010-2020 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.mqtt.homeassistant.internal;

import java.lang.reflect.Type;

import org.eclipse.jdt.annotation.NonNullByDefault;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * The {@link ConnectionDeserializer} will de-serialize a connection-list
 *
 * see: https://www.home-assistant.io/integrations/sensor.mqtt/#connections
 *
 * @author Jan N. Klug - Initial contribution
 */

@NonNullByDefault({ org.eclipse.jdt.annotation.DefaultLocation.RETURN_TYPE,
        org.eclipse.jdt.annotation.DefaultLocation.TYPE_BOUND,
        org.eclipse.jdt.annotation.DefaultLocation.TYPE_ARGUMENT })
public class ConnectionDeserializer implements JsonDeserializer<BaseChannelConfiguration.Connection> {
    @Override
    public BaseChannelConfiguration.Connection deserialize(JsonElement json, Type typeOfT,
            JsonDeserializationContext context) throws JsonParseException {
        JsonArray list = json.getAsJsonArray();
        BaseChannelConfiguration.Connection conn = new BaseChannelConfiguration.Connection();
        conn.type = list.get(0).getAsString();
        conn.identifier = list.get(1).getAsString();
        return conn;
    }
}
