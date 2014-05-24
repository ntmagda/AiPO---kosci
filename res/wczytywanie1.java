\documentclass{article}
\usepackage{graphicx}
\usepackage{polski}
\usepackage[cp1250]{inputenc}
\usepackage{url}
\usepackage[margin=2.5cm]{geometry} %layout
% the following is needed for syntax highlighting
\usepackage{color}
\usepackage{listings} % needed for the inclusion of source code

\definecolor{dkgreen}{rgb}{0,0.6,0}
\definecolor{gray}{rgb}{0.5,0.5,0.5}
\definecolor{mauve}{rgb}{0.58,0,0.82}

\lstset{%
  language=Java,                  % the language of the code
  basicstyle=\footnotesize,       % the size of the fonts that are used for the code
  numbers=left,                   % where to put the line-numbers
  numberstyle=\tiny\color{gray},  % the style that is used for the line-numbers
  stepnumber=1,                   % the step between two line-numbers. If it's 1, each line 
                                  % will be numbered
  numbersep=5pt,                  % how far the line-numbers are from the code
  backgroundcolor=\color{white},  % choose the background color. You must add \usepackage{color}
  showspaces=false,               % show spaces adding particular underscores
  showstringspaces=false,         % underline spaces within strings
  showtabs=false,                 % show tabs within strings adding particular underscores
  frame=single,                   % adds a frame around the code
  rulecolor=\color{black},        % if not set, the frame-color may be changed on line-breaks within not-black text (e.g. commens (green here))
  tabsize=4,                      % sets default tabsize to 2 spaces
  captionpos=b,                   % sets the caption-position to bottom
  breaklines=true,                % sets automatic line breaking
  breakatwhitespace=false,        % sets if automatic breaks should only happen at whitespace
  title=\lstname,                 % show the filename of files included with \lstinputlisting;
                                  % also try caption instead of title
  keywordstyle=\color{blue},          % keyword style
  commentstyle=\color{dkgreen},       % comment style
  stringstyle=\color{mauve},         % string literal style
  escapeinside={\%*}{*)},            % if you want to add a comment within your code
  morekeywords={*,...}               % if you want to add more keywords to the set
}

\begin{document}

\begin{titlepage}
\begin{center}

\textsc{\LARGE Nazwa przedmiotu}\\[1.5cm]

\vskip 3cm

\textsc{\Large Sprawozdanie I}\\[0.5cm]

{ \huge \bfseries Temat sprawozdania \\[0.4cm] }

\vskip 6cm
% Author and supervisor
\begin{minipage}{0.4\textwidth}
\begin{flushleft} \large
\emph{Autor:}\\
Jan Kowalski
\end{flushleft}
\end{minipage}
\begin{minipage}{0.4\textwidth}
\begin{flushright} \large
\emph{Prowadz¹cy æwiczenia:} \\
Krzysztof Misztal
\end{flushright}
\end{minipage}

\vfill

% Bottom of the page
{\large Kraków, DATA%\today
}

\end{center}
\end{titlepage}

\tableofcontents
\clearpage

\section{Temat zadania}
Zawartoœæ sekcji ...

\begin{figure}[!h]
    \centering
    \includegraphics[width=\textwidth]{kobieta.jpg}
    \caption{Opis obrazka}
    \label{simulationfigure}
\end{figure}

\section{Proponowane rozwi¹zanie}
Zawartoœæ sekcji ...

\subsection{Krok 1: nazwa Metody I}
Ta podsekcja powinna zawieraæ opis Metody I.

\subsubsection{Czynnoœci}
Sekcja zawiera pseudokod/kod Metody I.
\begin{lstlisting}
public void process(
            MarvinImage imageIn,
            MarvinImage imageOut,
            MarvinAttributes attributesOut,
            MarvinImageMask mask,
            boolean previewMode) {
        int r, g, b;
        for (int x = 0; x < imageIn.getWidth(); x++) {
            for (int y = 0; y < imageIn.getHeight(); y++) {
                r = (255 - (int) imageIn.getIntComponent0(x, y));
                g = (255 - (int) imageIn.getIntComponent1(x, y));
                b = (255 - (int) imageIn.getIntComponent2(x, y));

                imageOut.setIntColor(x, y, r, g, b);
            }
        }
    }
\end{lstlisting}

\subsubsection{Rezultat}
Ta sekcja powinna zawieraæ rezultat wykonania powy¿szej Metody I najlepiej w formie obrazka.

\subsection{Krok 2: nazwa metody}
Zawartoœæ podsekcji ...

\subsubsection{Czynnoœci}
Zawartoœæ podsekcji ...

\subsubsection{Rezultat}
Zawartoœæ podsekcji ...

\subsection{Krok 3: nazwa metody}
Zawartoœæ podsekcji ...

\subsubsection{Czynnoœci}
Zawartoœæ podsekcji ...

\subsubsection{Rezultat}
Zawartoœæ podsekcji ...

\subsection{Krok 4: nazwa metody}
Zawartoœæ podsekcji ...

\subsubsection{Czynnoœci}
Zawartoœæ podsekcji ...

\subsubsection{Rezultat}
Zawartoœæ podsekcji ...

\section{Wnioski}
W tym miejscu proszê wpisaæ wnioski


\clearpage
\addcontentsline{toc}{section}{Literatura}
\begin{thebibliography}{9}

\bibitem{ConcreteMath}
Abramoff, Michael D., Paulo J. Magalhes, and Sunanda J. Ram. \emph{Image processing with ImageJ.} Biophotonics international 11.7 (2004): 36-43.

\bibitem{Simpson} Strona laboratorium 
\url{misztal.edu.pl}.

\end{thebibliography}

\end{document}
