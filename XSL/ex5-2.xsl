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

</xsl:stylesheet>
