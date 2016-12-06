package com.example.androidtest.activity;

public class text {

	public static void main(String[] args) {
		byte[] output = new byte[16];

		String input = "7815696ecbf1c96e6894b779456d330e";
		System.out.println("test");
		System.out.print(String.format("%#x", Byte.parseByte("0e")));
		for (int i = 15; i >= 0; i--) {

			// char c1 = input.charAt(i << 1);
			// char c2 = input.charAt((i << 1) + 1);
			//
			// byte b1 = convertC(c1);
			// byte b2 = convertC(c2);
			// output[i] = (byte)((b1 << 4) & 0xf0) + (b2 & 0x0f);

			String str = input.substring(i << 1, (i << 1) + 2);
			output[i] = Byte.parseByte(str, 16);
			//System.out.print(String.format("%#x", output[i]));
		}

	}
}
