package cn.studio.zps.blue.ljy.utils;

import cn.studio.zps.blue.ljy.domain.Admin;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.sf.json.JSONObject;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;

/**
 * @author 蔡荣镔
 */
public class Token {
    public static String createToken(Admin admin, String key) {
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(key);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes,SignatureAlgorithm.HS256.getJcaName());
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("admin",admin);
        JwtBuilder builder = Jwts.builder()
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
                .setPayload(jsonObject.toString())
                .signWith(SignatureAlgorithm.HS256,signingKey);
        return builder.compact();
    }
}
