/*
 * Catroid: An on-device visual programming system for Android devices
 * Copyright (C) 2010-2021 The Catrobat Team
 * (<http://developer.catrobat.org/credits>)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * An additional term exception under section 7 of the GNU Affero
 * General Public License, version 3, is available at
 * http://developer.catrobat.org/license_additional_term
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.catrobat.catroid.bluetooth;

import android.content.Context;

import org.catrobat.catroid.bluetooth.base.BluetoothDevice;
import org.catrobat.catroid.bluetooth.base.BluetoothDeviceFactory;
import org.catrobat.catroid.devices.arduino.ArduinoImpl;
import org.catrobat.catroid.devices.arduino.phiro.PhiroImpl;
import org.catrobat.catroid.devices.mindstorms.ev3.LegoEV3Impl;
import org.catrobat.catroid.devices.mindstorms.nxt.LegoNXTImpl;
import org.catrobat.catroid.devices.multiplayer.Multiplayer;

public class BluetoothDeviceFactoryImpl implements BluetoothDeviceFactory {

	@Override
	public <T extends BluetoothDevice> BluetoothDevice createDevice(Class<T> service, Context applicationContext) {

		if (service == BluetoothDevice.LEGO_NXT) {
			return new LegoNXTImpl(applicationContext);
		}

		if (service == BluetoothDevice.LEGO_EV3) {
			return new LegoEV3Impl(applicationContext);
		}

		if (service == BluetoothDevice.PHIRO) {
			return new PhiroImpl();
		}

		if (service == BluetoothDevice.ARDUINO) {
			return new ArduinoImpl();
		}

		if (service == BluetoothDevice.MULTIPLAYER) {
			return new Multiplayer();
		}

		return null; // may throw exception
	}
}
