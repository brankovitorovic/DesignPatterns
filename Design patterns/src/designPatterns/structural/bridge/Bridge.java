package designPatterns.structural.bridge;

class Remote {

	Device device;

	public Remote(Device device) {
		this.device = device;
	}

	public void togglePower() {
		if(device.isEnabled()) {
			device.disable();
		}else {
			device.enable();
		}
	}
	
	public void volumeUp() {
		device.setVolume(device.getVolume() + 1);
	}
	
	public void volumeDown() {
		device.setVolume(device.getVolume() - 1);
	}
	
	public void channelUp() {
		device.setChannel(device.getChannel() + 1);
	}

	public void channelDown() {
		device.setChannel(device.getChannel() - 1);
	}
}

interface Device {
	boolean isEnabled();
	void enable();
	void disable();
	int getVolume();
	void setVolume(int volume);
	int getChannel();
	void setChannel(int channel);
}

class Radio implements Device{
	
	boolean enabled;
	int volume;
	int channel;
	
	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public void enable() {
		enabled = true;
	}

	@Override
	public void disable() {
		enabled = false;
	}

	@Override
	public int getVolume() {
		return volume;
	}

	@Override
	public void setVolume(int volume) {
		System.out.println("Volume on radio is now on " + this.volume);
		this.volume = volume;
	}

	@Override
	public int getChannel() {
		return channel;
	}

	@Override
	public void setChannel(int channel) {
		System.out.println("Radio number on radio is " + channel);
		this.channel = channel;
	}
	
}

class TV implements Device {
	
	boolean enabled;
	int volume;
	int channel;
	
	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public void enable() {
		enabled = true;
	}

	@Override
	public void disable() {
		enabled = false;
	}

	@Override
	public int getVolume() {
		return volume;
	}

	@Override
	public void setVolume(int volume) {
		System.out.println("Volume on tv is now on " + this.volume);
		this.volume = volume;
	}

	@Override
	public int getChannel() {
		return channel;
	}

	@Override
	public void setChannel(int channel) {
		System.out.println("Channel number on tv is " + channel);
		this.channel = channel;
	}
	
	
	
}

public class Bridge {

	public static void main(String[] args) {
		
		TV tv = new TV();
		
		Radio radio = new Radio();
		
		Remote remote = new Remote(tv);
		
		remote.channelUp();
		
	}
	
}
