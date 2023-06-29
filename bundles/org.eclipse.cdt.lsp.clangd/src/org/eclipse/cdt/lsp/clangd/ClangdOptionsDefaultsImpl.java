package org.eclipse.cdt.lsp.clangd;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.eclipse.cdt.utils.PathUtil;
import org.eclipse.core.runtime.IPath;

public class ClangdOptionsDefaultsImpl implements ClangdOptionsDefaults {

	@Override
	public boolean preferClangd() {
		return false;
	}

	@Override
	public String clangdPath() {
		return Optional.ofNullable(PathUtil.findProgramLocation("clangd", null)) //$NON-NLS-1$
				.map(IPath::toOSString)//
				.orElse("clangd"); //  //$NON-NLS-1$
	}

	@Override
	public boolean useTidy() {
		return true;
	}

	@Override
	public boolean useBackgroundIndex() {
		return true;
	}

	@Override
	public String completionStyle() {
		return "detailed";
	}

	@Override
	public boolean prettyPrint() {
		return true;
	}

	@Override
	public String queryDriver() {
		return Optional.ofNullable(PathUtil.findProgramLocation("gcc", null)) //$NON-NLS-1$
				.map(p -> p.removeLastSegments(1).append(IPath.SEPARATOR + "*"))// //$NON-NLS-1$
				.map(IPath::toString)//
				.orElse(""); //  //$NON-NLS-1$
	}

	@Override
	public List<String> customOptions() {
		return Collections.emptyList();
	}

}