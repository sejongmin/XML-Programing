<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/">
    <HTML>
      <HEAD>
        <TITLE>Video Ranking</TITLE>
      </HEAD>
      <BODY>
        <H2> Weekend Video Rental Ranking </H2>
        <TABLE border="1">
          <TR>
            <TH>RANK</TH>
            <TH>TITLE</TH>
            <TH>GENRE</TH>
            <TH>PROTAGONIST</TH>
            <TH>DIRECTOR</TH>
            <TH>PRODUCTION</TH>
            <TH>FREQUENCY</TH>
          </TR>
          <xsl:for-each select="video_catalog/video">
            <xsl:sort select="number(num)" order="descending"/>
            <TR>
              <TD style="text-align: center">
                <xsl:value-of select="position()" />
              </TD>
              <TD>
                <xsl:value-of select="title" />
              </TD>
              <TD>
                <xsl:value-of select="genre" />
              </TD>
              <TD>
                <xsl:value-of select="info/protagonist" />
              </TD>
              <TD>
                <xsl:value-of select="info/director" />
              </TD>
              <TD>
                <xsl:value-of select="info/production" />
              </TD>
              <TD style="text-align: center">
                <xsl:value-of select="num" />
              </TD>
            </TR>
          </xsl:for-each>
        </TABLE>
      </BODY>
    </HTML>
  </xsl:template>

</xsl:stylesheet>
