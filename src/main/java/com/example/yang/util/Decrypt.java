package com.example.yang.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Decrypt {
    private byte[] keyBs;

//    public static void main(String[] args) throws Exception {
//        Decrypt d = new Decrypt("test key");
//        System.out.println(d.decrypt("FIAfJPGRmFZWkaxPQ1XrJZVbv2JwdjfLk4jx0k/U1deAqYK3AXOZ5zcHt/cC4ZNTqYwWUW/EoL+b2hW/C4zoAQQ5CeMtbxX2zHjm+E4nX/Aww+FHUL6iuIMaeL2KLxqdtbHRC50vgC2YI7xohnb3KuCNBMUzLiPeNIpVdnYaeteCmSaESb+AZpJB9PExzTpRDzCRv+T6o5vlzaE8UgIneC1sYu85BnPBEMTSuj1ZZzfdQi7ZW992Z4dmJxn9e8FL2VArNm99f5Io3c2O4AcNsQENNKtfAAxVjCqc3mg5jF0nKabA+u/5vrUD76flX1UOF5fzJ0sApG2OEn9wfyPDRBsApn9o+fceF9hNrYBGsdtZrZYyGG387CGOtKsuj8e2E8SNp+Pn4E9oYejOTR+ZNLNi+twxaXVlJhr6l+RXYwEiMGQE9zGFBD6h2dOhKh3W84p1GEYnSRIz1+9/Hp66arjC7RCrhuW5OjCj4QFEQJiwgL45XryxHtiZ7JdAlPmjVsL03CxxFZarzxzffryrWUG3VkRdHRHbTsC34+ScoL5MTDU1QAWdqUC1T7xT0lCvQELaIhBTXAYrznJl6PlA83oqlMxpHh0gZBB1jFbfoUr7OQbBs1xqzpYK6Yjux6diwpQB1zlZErYJUfCqK7G/zI9yK/60b4HW0k3M+AvzMcw=")); //hello world
//    }

    public Decrypt(String key) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            // won't happen
        }
        keyBs = digest.digest(key.getBytes(StandardCharsets.UTF_8));
    }

    public String decrypt(String base64) throws Exception {
        byte[] decode = Base64.getDecoder().decode(base64);
        Cipher cipher = Cipher.getInstance("AES/CBC/NOPADDING");
        byte[] iv = new byte[16];
        System.arraycopy(decode, 0, iv, 0, 16);
        byte[] data = new byte[decode.length - 16];
        System.arraycopy(decode, 16, data, 0, data.length);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(keyBs, "AES"), new IvParameterSpec(iv));
        byte[] r = cipher.doFinal(data);
        if (r.length > 0) {
            int p = r.length - 1;
            for (; p >= 0 && r[p] <= 16; p--) {
            }
            if (p != r.length - 1) {
                byte[] rr = new byte[p + 1];
                System.arraycopy(r, 0, rr, 0, p + 1);
                r = rr;
            }
        }
        return new String(r, StandardCharsets.UTF_8);
    }
}