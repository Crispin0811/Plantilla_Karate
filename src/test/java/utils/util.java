package utils;

import java.util.Base64;
import java.util.UUID;

public class util {

	
	public String random_email() {
		String characters = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		return generate_random(characters, 10)+"@"+generate_random(characters, 6)+".com";
	}


	private String generate_random(String available_characters, int result_length) {
		String result = "";
		int charactersLength = available_characters.length();
		for (int i = 0; i < result_length; i++) {
			result += available_characters.charAt((int) Math.floor(Math.random() * charactersLength));
		}
		return result;
	}

	public String random_alphanumeric(int length) {
		String characters = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		return generate_random(characters, length);
	}

	public String random_string(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		return generate_random(characters, length);
	}

	public String random_number(int length) {
		String characters = "123456789";
		return generate_random(characters, length);
	}

	public String random_decimal_number(int length, int decimals) {
		String characters = "123456789";
		String entero = generate_random(characters, length);
		String decimal = generate_random(characters, decimals);

		return String.format("%s.%s", entero, decimal);
	}

	public String string_replace(String text, String stringToFind, String stringToReplace) {
		return text.replace(stringToFind, stringToReplace);
	}

	public String random_uuid() {
		return UUID.randomUUID() + "";
	}

	public String generator_fingerprint(String hardware_id) {
		String fingerPrint = "{\"time_stamp\":\"2020-02-20T10:49:04-07:00\",\"hardware_id\":\"" + hardware_id
				+ "\",\"geolocalization\":{\"latitude\":\"-90.0\",\"longitude\":\"-70.24436930849632\"},\"device_model\":\"Samsung Galaxy J4 Core\",\"device_name\":\"My Phone\",\"os_name\":\"Android Donut\",\"os_version\":\"Android 1.6\",\"os_id\":\"746b9f55be4758b7\",\"language\":\"Spanish\",\"ip\":\"192.168.0.1\",\"wifi_ssid\":\"TOWER1\",\"celltower_id\":\"746babcde345be4758b7\",\"localization_area_id\":\"098af987ce88\",\"compromised\":false,\"emulator\":false}";
		return Base64.getEncoder().encodeToString(fingerPrint.getBytes());
	}

	public String random_special_characters(int length) {
		String characters = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!*·$%&/()=?¿^+-.,;:_";
		return generate_random(characters, length);
	}

	public String cut_string(String texto, int inicio, int fin) {
		return texto.substring(inicio, fin);
	}

	public String get_bin_card(String texto, int cantidad) {
		return texto.substring(0, cantidad);
	}

	public String get_last_digit_card(String texto, int cantidad) {
		return texto.substring(texto.length() - cantidad, texto.length());
	}

	public String random_accent_marks(int length) {
		String characters = "áéíóúÁÉÍÓÚ";
		return generate_random(characters, length);
	}

	public String ascendant_number(int length) {
		String result = "";
		int number = (int) (Math.floor(Math.random() * (6 - 0)) + 0);
		for (int i = 0; i < length; i++) {
			result += number + i;
		}
		return result;
	}

	public String descend_number(int length) {
		String result = "";
		int number = (int) (Math.floor(Math.random() * (6 - 0)) + 0);
		for (int i = 0; i < length; i++) {
			result += number - i;
		}
		return result;
	}

	public String coincidence_number(int length) {
		String result = "";
		int number = (int) Math.floor(Math.random() * 10);
		for (int i = 0; i < length; i++) {
			result += number;
		}
		return result;
	}
	
	
	/*
	public String decode_coupon(String base62_encoded) {
		var UUID = Java.type('java.util.UUID');
		var Base62 = Java.type('io.seruco.encoding.base62.Base62');
		var Base62Util = Java.type('utils.Base62_util');
		var base62Instance = Base62.createInstanceWithInvertedCharacterSet();
		var decodedByteArray = base62Instance.decode(base62_encoded.getBytes());
		return Base62Util.getGuidFromByteArray(decodedByteArray);
		
		
	}
	
*/
	
	
	
	
}
