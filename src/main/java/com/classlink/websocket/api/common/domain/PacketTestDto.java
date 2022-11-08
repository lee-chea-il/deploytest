package com.classlink.websocket.api.common.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PacketTestDto {
	public String name;
    public int age;
    public float height;
    public double weight;
    public boolean isAlive;
    public InnerClass innerClass;

    // Ignore this
    public String introduce;
}

class InnerClass {
    public byte[] byteArray = "함정욱".getBytes();
    public List<String> availableLanguage = new ArrayList<String>();
    public int[] birthday = new int[] { 1998, 2, 23 };

    public InnerClass() {
        availableLanguage.add("KOR");
        availableLanguage.add("ENG");
        availableLanguage.add("JAP");
    }
}
