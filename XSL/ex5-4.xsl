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
  
  
<xsl:template match="header">
	<DIV> 
	<xsl:apply-templates select="to" />
	</DIV>
	<DIV>
	<xsl:apply-templates select="from" />
	</DIV>
	<DIV style="text-align:right">
	<xsl:value-of select="date" />
	</DIV>
</xsl:template>
  
  
<xsl:template match="to">
	<SPAN style="font-family: Arial Black"> 
	<xsl:value-of select="heading" />
	</SPAN>
	<SPAN style="font-weight: bold">
	<xsl:value-of select="name" />
	</SPAN>
</xsl:template>
  
<xsl:template match="from">
	<SPAN style="font-family: Arial Black"> 
	<xsl:value-of select="heading" />
	</SPAN>
	<SPAN style="font-style: italic">
	<xsl:value-of select="name" />
	</SPAN>
</xsl:template>

  
<xsl:template match="body">
	<DIV style="margin-top: 1em"> 
	<xsl:apply-templates />
	</DIV>
</xsl:template>

  
<xsl:template match="p">
	<DIV style="margin-top:0.3em">
    <!--<xsl:value-of />-->
    <xsl:value-of select="."/>
	</DIV>
</xsl:template>

</xsl:stylesheet>
