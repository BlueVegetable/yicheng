package cn.studio.zps.blue.ljy.utils;

import cn.studio.zps.blue.ljy.domain.Admin;
import io.jsonwebtoken.*;
import jdk.nashorn.internal.parser.JSONParser;
import net.sf.json.JSONObject;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 蔡荣镔
 */
public class Token {

    /**
     * JWT的签发者
     */
    private static final String ISSURE="蔡荣镔";
    private static Map<String,Object> header=new HashMap<String,Object>(2);
    private static final String KEY="aslkdjflaskjdfiozjxkvnwolketuo2i3u54r32094ufrjdzilkcjnazoise78u908q22ejhfkdlzncvo2w835r4yhnds";

    static{
        header.put("typ","JWT");
        header.put("alg","HS256");
    }

//    public static String createToken(Admin admin, String key) {
//        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(key);
//        Key signingKey = new SecretKeySpec(apiKeySecretBytes,SignatureAlgorithm.HS256.getJcaName());
//        JSONObject jsonObject=new JSONObject();
//        jsonObject.put("admin",admin);
//        JwtBuilder builder = Jwts.builder()
//                .setHeaderParam("typ","JWT")
//                .setHeaderParam("alg","HS256")
//                .setPayload(jsonObject.toString())
//                .signWith(SignatureAlgorithm.HS256,signingKey);
//        return builder.compact();
//    }
//    public static String createToken(String id, String subject, long ttlMillis,
//                                     String key, Map<String,Object> header ,
//                                     Map<String,Object> claims) {
//        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
//
//        long nowMillis = System.currentTimeMillis();
//        Date now = new Date(nowMillis);
//
//        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(key);
//        Key signingKey = new SecretKeySpec(apiKeySecretBytes,signatureAlgorithm.getJcaName());
//
//        JwtBuilder builder = Jwts.builder()
//                .setHeader(header)
//                .setId(id)
//                .setIssuedAt(now)
//                .setSubject(subject)
//                .setIssuer(ISSURE)
//                .setClaims(claims)
//                .signWith(signatureAlgorithm,signingKey);
//
//        if(ttlMillis >= 0) {
//            long expMillis = nowMillis + ttlMillis;
//            Date exp = new Date(expMillis);
//            builder.setExpiration(exp);
//        }
//
//        return builder.compact();
//    }

//    public void parseJWT(String jwt,String apiKey) {
//        //This line will throw an exception if it is not a signed JWS (as expected)
//        Claims claims = Jwts.parser()
//                .setSigningKey(DatatypeConverter.parseBase64Binary(apiKey))
//                .parseClaimsJws(jwt).getBody();
//        System.out.println("ID: " + claims.getId());
//        System.out.println("Subject: " + claims.getSubject());
//        System.out.println("Issuer: " + claims.getIssuer());
//        System.out.println("Expiration: " + claims.getExpiration());
//    }

    public static String createToken(Object object) {
        JSONObject json = JSONObject.fromObject(object);
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(KEY);

        JwtBuilder builder = Jwts.builder()
                .setHeader(header)
                .setPayload(json.toString())
                .signWith(signatureAlgorithm,apiKeySecretBytes);

        return builder.compact();
    }

//    public static Object parseToken(String jwt,Class className) {
//        Claims claims = Jwts.parser()
//                .setSigningKey(DatatypeConverter.parseBase64Binary(KEY))
//                .parseClaimsJws(jwt).getBody();
//        System.out.println("head:"+Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(KEY)).parseClaimsJws(jwt).getHeader());
//        String string=claims.toString();
//        System.out.println(string);
//        JSONObject object = new JSONObject().fromObject(string);
//        System.out.println(object);
//        return JSONObject.toBean(object,className);
//    }

}
