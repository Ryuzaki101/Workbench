<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="xml" encoding="UTF-8" indent="yes" />

<xsl:template match="/">
<project name="project" default="svnCheckout">

<target name="svnCheckout">
      <xsl:for-each select="/psf/provider[@id='org.eclipse.team.svn.core.svnnature']/project">
      	<xsl:variable name="first0" select='substring-before(@reference,",")'/>
      	<xsl:variable name='rest1' select='substring-after(@reference,",")'/>
      	<xsl:variable name='svn_uri' select='substring-before($rest1,",")' />
      	<xsl:variable name='rest2' select='substring-after($rest1,",")'/>
      	<xsl:variable name='project_name' select='substring-before($rest2,",")'/>
      	<java classname="org.tmatesoft.svn.cli.SVN" dir="${{workspace.dir}}" fork="true">
      		<arg value="co"/>
      		<arg value="--username"/>
      		<arg value="${{svn.user}}"/>
      		<arg value="--password"/>
      		<arg value="${{svn.password}}"/>
      		<arg value="--no-auth-cache" />
      		<arg value="--non-interactive"/>
      		<arg value="--trust-server-cert"/>
      		<arg>
      		<xsl:attribute name="value"><xsl:value-of select='$svn_uri'/></xsl:attribute>
      		</arg>
      		<arg>
      		<xsl:attribute name="value"><xsl:value-of select='$project_name'/></xsl:attribute>
      		</arg>
      <classpath>
        <pathelement location="${{svnkit.cli.jar}}" />
        <pathelement location="${{svnkit.jar}}" />
        <pathelement location="${{trilead.jar}}" />
      </classpath>
    </java>
    </xsl:for-each>
</target>

</project>
</xsl:template>
</xsl:stylesheet>