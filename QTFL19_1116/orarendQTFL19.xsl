<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:foo="http://www.foo.org/" xmlns:bar="http://www.bar.org">

  <xsl:template match="/">
    <html>
      <body>
        <h2>Órarend</h2>
        <table border="4">
          <tr bgcolor="#808080">
            <th>ID</th>
            <th>Targy</th>
            <th>Idopont</th>
            <th>Helyszin</th>
            <th>Oktato</th>
            <th>Szak</th>
          </tr>

          <xml:for-each select="orarend/ora">
            <tr>
              <td>
                <xsl:value-of select ="@id"/>
              </td>

              <td>
                <xsl:value-of select ="@targy"/>
              </td>

              <td>
                <xsl:value-of select ="@idopont"/>
              </td>

              <td>
                <xsl:value-of select ="@helyszin"/>
              </td>

              <td>
                <xsl:value-of select ="@oktato"/>
              </td>

              <td>
                <xsl:value-of select ="@szak"/>
              </td>
            </tr>
          </xml:for-each>
          
        </table>
      </body>
    </html>


  </xsl:template>
</xsl:stylesheet>