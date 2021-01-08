/*
 *
 *  Copyright (c) 2008-2018, Hazelcast, Inc. All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package com.hazelcast.springboot.caching;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import com.hazelcast.config.Config;
import com.hazelcast.config.ManagementCenterConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

@SpringBootApplication
@EnableCaching
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public Config hazelCastConfig() {
		return new Config().setManagementCenterConfig(new ManagementCenterConfig().setScriptingEnabled(true));

	}
	
	@Bean
	public HazelcastInstance hazelcastInstance(Config hazelCastConfig) {
		return Hazelcast.newHazelcastInstance(hazelCastConfig);
	}

	@Bean
	public Map<String, String> accountMap(HazelcastInstance hazelcastInstance) {
		Map<String, String> map = hazelcastInstance.getMap("books");
		map.put("key1", "abu1");
		map.put("key2", "thalha2");
		return map;
	}
}
