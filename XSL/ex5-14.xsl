<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/">
    <xsl:apply-templates />
  </xsl:template>

  <xsl:template match="video_catalog">
    <HTML>
      <HEAD>
        <TITLE> Video Ranking </TITLE>
      </HEAD>
      <BODY>
        <H1> Ranking By Frequency </H1>
        <TABLE border="1">
          <xsl:for-each select="video">
            <xsl:choose>
              <xsl:when test="num[. >= 200]">
                <TR style="text-align: center">
                  <TD style="color: red">
                    The Highest Level
                  </TD>
                  <TD>
                    <xsl:value-of select="title" />
                  </TD>
                </TR>
              </xsl:when>
              <xsl:when test="num[(. &lt; 200) and (. >= 150)]">
                <TR style="text-align: center">
                  <TD style="color: brown">
                    Premium Level
                  </TD>
                  <TD>
                    <xsl:value-of select="title" />
                  </TD>
                </TR>
              </xsl:when>
              <xsl:otherwise>
                <TR style="text-align: center">
                  <TD style="color: blue">
                    Intermediate Level
                  </TD>
                  <TD>
                    <xsl:value-of select="title" />
                  </TD>
                </TR>
              </xsl:otherwise>
            </xsl:choose>

          </xsl:for-each>
        </TABLE>
      </BODY>
    </HTML>
  </xsl:template>

</xsl:stylesheet>
