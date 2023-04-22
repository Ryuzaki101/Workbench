package de.wisag.automation.micas.module.ui.internal.printing;

class PlaceholderResolver {

    interface Resolver {
        String resolve(String key);
    }

    public final static String START_TOKEN = "${";
    private final static String END_TOKEN = "}";
    final private Resolver resolver;

    public PlaceholderResolver(Resolver resolver) {
        super();
        this.resolver = resolver;
    }

    public String resolve(String key) {
        return resolvePlaceholder(resolver, key);
    }

    private String resolvePlaceholder(Resolver resolver, String key) {
        String value = resolver.resolve(key);
        if (value == null) {
            return key;
        }
        int startIndex = -1;
        int endIndex = -1;
        boolean inToken = false;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < value.length(); i++) {
            String startToken = "";
            if (i < value.length() - 1) {
                startToken = value.substring(i, i + 2);
            }
            if (START_TOKEN.equals(startToken)) {
                startIndex = i;
                inToken = true;
            }
            if (!inToken) {
                sb.append(value.charAt(i));
            }
            String endToken = value.substring(i, i + 1);
            if (END_TOKEN.equals(endToken)) {
                endIndex = i;
                inToken = false;
                String subKey = value.substring(startIndex + 2, endIndex);
                String subValue = resolver.resolve(subKey);
                sb.append(subValue);
            }
        }

        return sb.toString();

    }

    public Resolver getResolver() {
        return resolver;
    }

}