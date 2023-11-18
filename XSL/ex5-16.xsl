<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/">
    <xsl:apply-templates />
  </xsl:template>

  <xsl:template match="products">
    <HTML>
      <HEAD>
        <TITLE> Menu </TITLE>
      </HEAD>
      <BODY>
        <H1>Coffee shop menu</H1>
        <TABLE border="1" width="200em">
          <CAPTION>Food</CAPTION>
          <TR>
            <TH> Food </TH>
            <TH> Price </TH>
          </TR>
          <xsl:apply-templates select="food" />
        </TABLE>
        <br/>
        <TABLE border="1" width="200em">
          <CAPTION>Beverage</CAPTION>
          <TR>
            <TH> Beverage </TH>
            <TH> Price </TH>
          </TR>
          <xsl:apply-templates select="beverage" />
        </TABLE>
      </BODY>
    </HTML>
  </xsl:template>

  <xsl:template match="food|beverage">
    <TR>
      <TD style="text-align:center">
        <xsl:value-of select="item" />
      </TD>
      <TD>
        <xsl:apply-templates select="price" />
      </TD>
    </TR>
  </xsl:template>
  <xsl:template match="price">
    <xsl:value-of select="concat(., ' Won')"/>
  </xsl:template>

</xsl:stylesheet>
