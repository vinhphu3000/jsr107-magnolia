package nl.vpro.magnolia.jsr107.mock;

import info.magnolia.module.cache.Cache;
import info.magnolia.module.cache.CacheFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A mock Magnolia CacheFactory
 * @author Michiel Meeuwissen
 * @since 1.0
 */
public class MockCacheFactory implements CacheFactory {

    public final Map<String, Cache> caches = new HashMap<>();
    @Override
    public Cache getCache(String name) {
        if (! caches.containsKey(name)) {
            caches.put(name, new MockCache(name));
        }
        return caches.get(name);

    }

    @Override
    public void start(boolean isRestart) {

    }

    @Override
    public void stop(boolean isRestart) {

    }

    @Override
    public List<String> getCacheNames() {
        return new ArrayList<>(caches.keySet());

    }
}
