package dk.lemu.tools.filehandler;

import dk.lemu.tools.logging.Logging;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TypeParser {
  private static Logging logger = new Logging();

  private static String format1 = "dd-MMM-yyyy HH:mm:ss";
  private static String format2 = "d-MMM-yyyy HH:mm:ss";
  private static String format3 = "dd-MM-yyyy HH:mm:ss";
  private static String format4 = "d-MM-yyyy HH:mm:ss";
  private static String format5 = "dd-MMM-yyyy";
  private static String format6 = "d-MMM-yyyy";
  private static String format7 = "dd-MMM-yyyy";
  private static String format8 = "d-MMM-yyyy";
  static public Serializable fromCSVFile(Class objectClass, String value) {
    try {
      if (value != null && !value.equals("") && !value.isEmpty() &&  value != "") {
        if (objectClass == String.class) {
          return value;
        } else if (objectClass == Integer.class) {
          return Integer.parseInt(value);
        } else if (objectClass == Boolean.class) {
          if (value.equalsIgnoreCase("n") || value.equalsIgnoreCase("0")) {
            value = "false";
          } else if (value.equalsIgnoreCase("y") || value.equalsIgnoreCase("j") || value.equalsIgnoreCase("1")) {
            value = "true";
          } else {
            value = "false";
          }
          return Boolean.parseBoolean(value);
        } else if (objectClass == Float.class) {
          return Float.parseFloat(value);
        } else if (objectClass == Long.class) {
          return Long.parseLong(value);
        } else if (objectClass == Short.class) {
          return Short.parseShort(value);
        } else if (objectClass == Double.class) {
          return Double.parseDouble(value);
        } else if (objectClass == Byte.class) {
          return Byte.parseByte(value);
        } else if (objectClass == Character.class) {
          return value.charAt(0);
        } else if (objectClass == Date.class) {
          SimpleDateFormat dt;
          try {
            dt = new SimpleDateFormat(format1, Locale.ENGLISH);
            return dt.parse(value);
          } catch (ParseException e) {
            try {
              dt = new SimpleDateFormat(format2, Locale.ENGLISH);
              return dt.parse(value);
            } catch (ParseException e2) {
              try {
                dt = new SimpleDateFormat(format3, Locale.ENGLISH);
                return dt.parse(value);
              } catch (ParseException e3) {
                try {
                  dt = new SimpleDateFormat(format4, Locale.ENGLISH);
                  return dt.parse(value);
                } catch (ParseException e4) {
                  try {
                    dt = new SimpleDateFormat(format5, Locale.ENGLISH);
                    return dt.parse(value);
                  } catch (ParseException e5) {
                    try {
                      dt = new SimpleDateFormat(format6, Locale.ENGLISH);
                      return dt.parse(value);
                    } catch (ParseException e6) {
                      try {
                        dt = new SimpleDateFormat(format7, Locale.ENGLISH);
                        return dt.parse(value);
                      } catch (ParseException e7) {
                        try {
                          dt = new SimpleDateFormat(format8, Locale.ENGLISH);
                          return dt.parse(value);
                        } catch (ParseException e8) {
                          throw new IllegalArgumentException("Date format not supported " + value);

                        }
                      }
                    }
                  }
                }
              }
            }
          }

        } else {
          throw new IllegalArgumentException("Type not supported " + objectClass.getSimpleName() + " from CSV files.");
        }
      } else {
        return null;
      }

    } catch (IllegalArgumentException e) {
      logger.log("Error parsing: " + value + ". of class: " + objectClass.getSimpleName() + ", with ERROR: " + e.toString());
      logger.log(e);
    } catch (Exception e) {
      logger.log("Other Exception. Error parsing: " + value + ". of class: " + objectClass.getSimpleName() + ", with ERROR: " + e.toString());
      logger.log(e);
    }
    return null;
  }
}
