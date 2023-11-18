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
        <H1> Ranking By Genre </H1>
        <BR />
        <H3> Drama Rental Ranking </H3>
        <TABLE border="1">
          <TR>
            <TH> RANK </TH>
            <TH> TITLE </TH>
            <TH> PROTAGONIST </TH>
            <TH> DIRECTOR </TH>
            <TH> PRODUCTION </TH>
            <TH> FREQUENCY </TH>
          </TR>
          <xsl:for-each select="video[genre = 'Drama']">
            <xsl:sort select="number(num)" order="descending"/>
            <TR>
              <TD style="text-align:center">
                <xsl:value-of select="position()"/>
              </TD>
              <TD>
                <xsl:value-of select="title" />
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
        <BR />
        <H3> Thriller Rental Ranking </H3>
        <TABLE border="1">
          <TR>
            <TH> RANK </TH>
            <TH> TITLE </TH>
            <TH> PROTAGONIST </TH>
            <TH> DIRECTOR </TH>
            <TH> PRODUCTION </TH>
            <TH> FREQUENCY </TH>
          </TR>
          <xsl:for-each select="video[genre = 'Thriller']">
            <xsl:sort select="number(num)" order="descending"/>
            <TR>
              <TD style="text-align:center">
                <xsl:value-of select="position()"/>
              </TD>
              <TD>
                <xsl:value-of select="title" />
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
        <BR />
        <H3> Comedy Rental Ranking </H3>
        <TABLE border="1">
          <TR>
            <TH> RANK </TH>
            <TH> TITLE </TH>
            <TH> PROTAGONIST </TH>
            <TH> DIRECTOR </TH>
            <TH> PRODUCTION </TH>
            <TH> FREQUENCY </TH>
          </TR>
          <xsl:for-each select="video[genre = 'Comedy']">
            <xsl:sort select="number(num)" order="descending"/>
            <TR>
              <TD style="text-align:center">
                <xsl:value-of select="position()"/>
              </TD>
              <TD>
                <xsl:value-of select="title" />
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
