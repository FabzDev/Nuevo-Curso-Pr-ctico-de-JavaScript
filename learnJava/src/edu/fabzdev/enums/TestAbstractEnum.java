/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fabzdev.enums;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author fabio
 */
public class TestAbstractEnum {
 
    public interface Converter {

        public Object convert(Object obj);
    }

    public static class HashMapBuilder<K, V> {

        private Map<K, V> res = new HashMap<>();

        private HashMapBuilder<K, V> add(K key, V value) {
            res.put(key, value);
            return this;
        }
        
        private Map<K,V> build(){
            return res;
        }
    }

    public enum Type {
        INT {
            @Override
            public void set(PreparedStatement pstmt, int index, Object value) throws SQLException {
                pstmt.setInt(index, (int) value);
            }

            @Override
            public Object convert(Object value) {
                return intConverterMap.get(getType(value).convert(value));
            }
        },
        STR {
            @Override
            public void set(PreparedStatement pstmt, int index, Object value) throws SQLException {
                pstmt.setString(index, (String) value);
            }

            @Override
            public Object convert(Object value) {
                return strConverterMap.get(getType(value).convert(value));
            }
            
        };
        
        private static final Map<Type, Converter> intConverterMap = new HashMapBuilder<Type, Converter>()
                .add(STR, (o) -> Type.passThru(o))
                .add(INT, (p) -> Type.convertIntToString(p))
                .build();
        
         private static final Map<Type, Converter> strConverterMap = new HashMapBuilder<Type, Converter>()
                .add(STR, (p) -> Type.convertStringToInt(p))
                .add(INT, (o) -> Type.passThru(o))
                .build();
        
        private static final Map<Class,Type> typesMap = new HashMapBuilder<Class,Type>()
                .add(Integer.class, INT)
                .add(String.class, STR)
                .build();
        
        private static Type getType(Object obj){
            return typesMap.get(obj.getClass());
        }
        
        private static Object passThru(Object value){
            return value;
        }
        
        private static Object convertStringToInt(Object strValue){
            return Integer.parseInt((String)strValue);
        }
        
        private static Object convertIntToString(Object intValue){
            return (String)intValue;
        }

        public abstract void set(PreparedStatement pstmt, int index, Object value) throws SQLException;

        public abstract Object convert(Object value);

    }
}
