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
      <xsl:value-of select="."/>
    </DIV>
  </xsl:template>

  <xsl:template match="list">
    <TABLE style="margin-top: 1em">
      <xsl:attribute name="border">
        <xsl:value-of select="@border" />
      </xsl:attribute>
      <xsl:attribute name="width">
        <xsl:value-of select="@width" />
      </xsl:attribute>
      <xsl:attribute name="height">
        <xsl:value-of select="@height" />
      </xsl:attribute>
      <xsl:apply-templates />
    </TABLE>
  </xsl:template>

  <xsl:template match="caption">
    <CAPTION>
      <xsl:value-of select="."/>
    </CAPTION>
  </xsl:template>

  <xsl:template match="row">
    <TR style="text-align:center">
      <xsl:apply-templates />
    </TR>
  </xsl:template>

  <xsl:template match="heading">
    <TH>
      <xsl:value-of select="."/>
    </TH>
  </xsl:template>

  <xsl:template match="data">
    <TD>
      <xsl:value-of select="."/>
    </TD>
  </xsl:template>

</xsl:stylesheet>
