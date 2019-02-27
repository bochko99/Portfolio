
package com.crypterium.cryptApi.oldback.pojos.users;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class DevicesCurrentModel {

    @Expose
    private DeviceHandleModel deviceHandleModel;

    public DeviceHandleModel getDeviceHandleModel() {
        return deviceHandleModel;
    }

    public DevicesCurrentModel setDeviceHandleModel(DeviceHandleModel deviceHandleModel) {
        this.deviceHandleModel = deviceHandleModel;
        return this;
    }
}
