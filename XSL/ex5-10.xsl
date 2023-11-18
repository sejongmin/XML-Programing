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
      <xsl:for-each select="caption">
        <CAPTION>
          <xsl:value-of select="."/>
        </CAPTION>
      </xsl:for-each>
      <xsl:for-each select="row">
        <TR style="text-align: center">
          <xsl:for-each select="heading">
            <TH>
              <xsl:value-of select="."/>
            </TH>
          </xsl:for-each>
          <xsl:for-each select="data">
            <TD>
              <xsl:value-of select="."/>
            </TD>
          </xsl:for-each>
        </TR>
      </xsl:for-each>
    </TABLE>
  </xsl:template>

</xsl:stylesheet>
