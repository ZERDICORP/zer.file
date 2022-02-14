package zer.file;



public enum FileType
{
  JSON("application/json"),
  HTML("text/html"),
  CSS("text/css"),
  JS("text/javascript"),
  PNG("image/png"),
  ICO("image/x-icon"),
	TXT("text/plain");

  String mimeType;
  
  FileType(String mimeType) { this.mimeType = mimeType; }

  public String mime() { return mimeType; }
}
