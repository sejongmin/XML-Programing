<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/">
    <xsl:apply-templates />
  </xsl:template>

  <xsl:template match="memo">
    <HTML>
      <HEAD>
        <TITLE> Note </TITLE>
      </HEAD>
      <BODY>
        <DIV>
          <xsl:apply-templates />
        </DIV>
      </BODY>
    </HTML>
  </xsl:template>
  
    <xsl:template match="body">
      <DIV>
        <xsl:apply-templates />
      </DIV>
    </xsl:template>

    <xsl:template match="p">
      <DIV>
        <!--<xsl:value-of />-->
        <xsl:value-of select="."/>
      </DIV>
    </xsl:template>

    <xsl:template match="figure">
      <DIV ALIGN="center" >
        <IMG>
          <xsl:attribute name="src" >
            <xsl:value-of select="@s" />
          </xsl:attribute>
          <xsl:attribute name="width" >
            <xsl:value-of select="@www" />
          </xsl:attribute>
          <xsl:attribute name="height" >
            <xsl:value-of select="@hh" />
          </xsl:attribute>
          <xsl:attribute name="alt" >
            <xsl:value-of select="@aq" />
          </xsl:attribute>
        </IMG>
      </DIV>
    </xsl:template>

 </xsl:stylesheet>
