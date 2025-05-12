package com.ayris.mockito;

import cn.hutool.core.date.DateUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class StartTest {

    @Mock
    public List mockList2;

    @Mock
    public List argList;

    @Mock
    Map<String,String> wordMap;

    @InjectMocks
    MyDictionary dict=new MyDictionary();

    @Captor
    public ArgumentCaptor argumentCaptor;

    @Spy
    public List spyList = new ArrayList();

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testMockList() {
        List mockList = mock(List.class);
        when(mockList.get(0)).thenReturn("first");

        System.out.println(mockList.get(0));

        System.out.println(mockList.get(999));
    }

    @Test
    public void testMockList2() {
        mockList2.add("first");
        Mockito.verify(mockList2).add("first");
        assertEquals(0, mockList2.size());

        Mockito.when(mockList2.size()).thenReturn(100);
        assertEquals(100,mockList2.size());

    }

    @Test
    public void testSpyList() {
        spyList.add("One");
        spyList.add("Two");

        Mockito.verify(spyList).add("One");
        Mockito.verify(spyList).add("Two");
        assertEquals(2, spyList.size());

        Mockito.doReturn(100).when(spyList).size();
        assertEquals(100, spyList.size());
    }

    @Test
    public void testArgCaptor() {
        argList.add("One");

        Mockito.verify(argList).add(argumentCaptor.capture());
        assertEquals("One", argumentCaptor.getValue());
    }

    @Test
    public void testInjectMocks() {
        Mockito.when(wordMap.get("aWord")).thenReturn("aMeaning");
        assertEquals("aMeaning", dict.getMeaning("aWord"));
    }
}

class MyDictionary {
    Map<String, String> wordMap;

    public MyDictionary() {
        wordMap = new HashMap<String, String>();
    }
    public void add(final String word, final String meaning) {
        wordMap.put(word, meaning);
    }
    public String getMeaning(final String word) {
        return wordMap.get(word);
    }
}