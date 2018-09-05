//package test.jwt;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.JwtBuilder;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//import javax.crypto.spec.SecretKeySpec;
//import javax.xml.bind.DatatypeConverter;
//import javax.xml.crypto.Data;
//import java.security.Key;
//import java.util.Date;
//
///**
// * Created by 260169 on 2017/12/27.
// */
//public class JwtHelper {
//    public static Claims parseJWT(String jsonWebToken,String base64Security){
//        try {
//            Claims claims= Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
//                               .parseClaimsJws(jsonWebToken).getBody();
//            return claims;
//        }
//        catch (Exception e){
//            return null;
//        }
//    }
//    //生成Token
//    public static String createJWT(String username,String userId,String role,String audience,String issuer,long TTLMillis,String base64Security){
//        SignatureAlgorithm signatureAlgorithm=SignatureAlgorithm.HS256;
//        long nowMillis=System.currentTimeMillis();
//        Date now=new Date(nowMillis);
//        //生成签名钥匙
//        byte[] apiKeySecretBytes=DatatypeConverter.parseBase64Binary(base64Security);
//        Key signingKey=new SecretKeySpec(apiKeySecretBytes,signatureAlgorithm.getJcaName());
//        //添加构成JWT的参数
//        JwtBuilder builder=Jwts.builder().setHeaderParam("typ","JWT")
//                               .claim("role",role)
//                               .claim("userid",userId)
//                               .claim("unique_name",username)
//                               .setIssuer(issuer)
//                               .setAudience(audience)
//                              .signWith(signatureAlgorithm,signingKey);
//        //添加过期时间
//        if(TTLMillis>=0){
//            long expMillis=nowMillis+TTLMillis;
//            Date exp=new Date(expMillis);
//            builder.setExpiration(exp).setNotBefore(now);
//        }
//        //生成JWT
//        return builder.compact();
//    }
//
//}
