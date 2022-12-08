package com.classlink.websocket.api.util;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.apache.commons.lang3.StringUtils;

import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Message;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommonUtil {
	
	public static <T> void nullSafeSet(T value, Consumer<T> setter) {
		if( value != null) {
			if( value.getClass() == List.class ) {
				
				List<?> listValue = (List<?>)value;
				log.info("list value : {}",value);
				if(!listValue.isEmpty()) {
					setter.accept(value);
				}
				
			}else {
				log.info("value : {}",value);
				setter.accept(value);
			}
		}
		
	}

	public static <T extends Message> void checkIfProtoParamAvailable(T proto) {

		Map<FieldDescriptor, Object> protoMap = proto.getAllFields();

		protoMap.forEach((key, value) -> {
			System.out.println("key.getName() : " + key.getName() + " / value : " + value);
		});

		List<Field> declaredFieldList = Arrays.asList(proto.getClass().getDeclaredFields());

		declaredFieldList.stream().filter((field) -> {
				
			field.setAccessible(true);

			char lastLetter = (field.getName().charAt(field.getName().length() - 1));

			return lastLetter != '_';
			
		}).forEach((field) -> {

			String fieldName = StringUtils.capitalize(field.getName().split("_")[0]);

			System.out.println("fieldName : " + fieldName);

			try {
				Object value = field.get(proto);

				System.out.println("fieldValue : " + value.toString());
				System.out.println("fieldType : " + field.getType().toString());

//				switch (field.getType().toString()) {
//				case String.class:
//					System.out.println("value : "+ value.toString());
//					break;
//
//				default:
//					break;
//				}

			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		return;
	}
}
