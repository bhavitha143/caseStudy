package com.washerservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.washer.WasherApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.washer.Repository.WasherRepo;
import com.washer.model.Washers;
import com.washer.service.WashService;


@SpringBootTest(classes = WasherApplication.class)
@RunWith(SpringRunner.class)
//@RunWith The annotation is used to configure a unit test that required Spring's dependency injection.
class WasherApplicationTests {
	
	@Autowired
	private WashService service;
	@MockBean
	private WasherRepo repo;


	@Test
	public void getwashersTest() {
		when(repo.findAll()).thenReturn(Stream
				.of(new Washers(22, "ayesha","USA","12345"),
						new Washers(55,"UK","jack","12345")).collect(Collectors.toList()));
		assertEquals(2, service.getwashers().size());
	}

	/*@Test
	public void getUserbyAddressTest() {
		String location="cc";
		when(repo.findBylocation(location))
				.thenReturn(Stream.of(new Washers(22,"sundar","UK","12345"))
						.collect(Collectors.toList()));
		assertEquals(1, service.getwasherbylocation(location).size());
	}*/

	@Test
	public void savewashersTest() {
		Washers washer = new Washers(2, "puja","Pune","123456");
		when(repo.save(washer)).thenReturn(washer);
		assertEquals(washer, service.addWasher(washer));
	}

	@Test
	public void deletewashersTest() {
		Washers washer = new Washers(1, "raju","Hyderabad","123456");	
		service.deletewasher(washer);
		verify(repo, times(1)).delete(washer);
	}
}
